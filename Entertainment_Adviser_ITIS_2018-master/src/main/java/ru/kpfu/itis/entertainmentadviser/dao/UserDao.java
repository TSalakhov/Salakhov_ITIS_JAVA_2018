package ru.kpfu.itis.entertainmentadviser.dao;

import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    User findByUsername(String username);
    List<User> showProfile(Long id);
    List<User> update(String username,String firstname,String secondname,Long id);
    List<User> allUsers(Long id);
    List<User> addFriend(Long id,Long id2);
    List<User> MyFriends(Long id);
    Boolean isChosenByUser(Long id,Long id2);
}
