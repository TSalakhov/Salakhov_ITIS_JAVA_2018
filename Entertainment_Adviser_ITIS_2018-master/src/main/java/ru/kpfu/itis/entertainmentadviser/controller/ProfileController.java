package ru.kpfu.itis.entertainmentadviser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entertainmentadviser.dao.UserDao;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.service.UserService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {
    @Autowired
    UserDao userDao;


    @GetMapping("/user/{id}")
    String showProfile(Model model, Authentication authentication, @PathVariable Long id) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long MainId = mainUser.getId();
        User user2 = userDao.findById(id);
        String username = user2.getUsername();
        List<User> oldUserFriend = userDao.MyFriends(MainId);
        for (User userFriend : oldUserFriend) {
                if (userDao.isChosenByUser(MainId, id)) {
                    List<User> user_profile = userDao.showProfile(id);
                    model.addAttribute("user_profile", user_profile);
                    return "simpleProfile";

            } else {
                    List<User> user_profile = userDao.showProfile(id);
                    model.addAttribute("user_profile", user_profile);
                    return "profile";

            }

        }
        if(oldUserFriend.size()==0){
            List<User> user_profile = userDao.showProfile(id);
            model.addAttribute("user_profile", user_profile);
            return "profile";
        }
        return "profile";
    }

    @PostMapping("/create")
    String correctProfile(Authentication authentication, @RequestParam String username, String firstname, String secondname) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long id = mainUser.getId();
        userDao.update(username, firstname, secondname, id);
        return "redirect:/user/" + mainUser.getId();
    }

    @GetMapping("/users")
    String allUsers(Model model, Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long id = mainUser.getId();
        List<User> AllUsers = userDao.allUsers(id);
        model.addAttribute("AllUsers", AllUsers);
        return "usersProfiles";
    }

    @PostMapping("/add")
    String addFriend(Authentication authentication, @RequestParam String username) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long id = mainUser.getId();
        User user = userDao.findByUsername(username);
        List<User> oldUserFriend = userDao.MyFriends(id);
        Long id2 = user.getId();
        for (User userFriend : oldUserFriend) {
                if (userDao.isChosenByUser(id, id2)) {

            } else {
                    userDao.addFriend(id, id2);
            }
        }
        if(oldUserFriend.size()==0) {
            userDao.addFriend(id, id2);
        }
        return "redirect:/users" ;
    }

    @GetMapping("/MyFriend")
    String myFriend(Authentication authentication, Model model) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long id = mainUser.getId();
        List<User> MyFriend = userDao.MyFriends(id);
        model.addAttribute("MyFriend", MyFriend);
        return "MyFriend";
    }
}
