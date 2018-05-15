package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(@ModelAttribute("model") ModelMap model, Authentication authentication, @RequestParam Optional<String> error) {
        if (authentication != null) {
            return "redirect:/";
        }
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping(value = {"/", "/home"})
    String home() {
        return "index";
    }
}
