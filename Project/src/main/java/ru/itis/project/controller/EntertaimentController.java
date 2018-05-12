package ru.itis.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.project.dao.EventDao;
import ru.itis.project.dao.TagDao;
import ru.itis.project.dao.UserDao;


@Controller
public class EntertaimentController {
@Autowired
    EventDao eventDao;
@Autowired
    TagDao tagDao;
@Autowired
    UserDao userDao;





}
