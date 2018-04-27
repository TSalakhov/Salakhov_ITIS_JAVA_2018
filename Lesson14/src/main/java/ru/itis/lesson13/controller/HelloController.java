package ru.itis.lesson13.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Start page";
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return "<form action=\"/showgreeting\">\n" +
                "\t\t\t<input type=\"text\" name=\"username\"></input>\n" +
                "\t\t\t<input type=\"submit\"></input>\n" +
                "</form>";
    }

    @RequestMapping("/showgreeting")
    public String showGreeting(@RequestParam String username) {
        return "Привет, " + username;
    }
}
