package ru.itis.lesson13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.lesson13.dao.AnswerDao;
import ru.itis.lesson13.dao.PollDao;
import ru.itis.lesson13.model.Answer;
import ru.itis.lesson13.model.Poll;

import java.util.List;

@Controller
public class PollController {
    @Autowired
    PollDao pollDao;
    @Autowired
    AnswerDao answerDao;

    @RequestMapping("/polls")
    String getAllPolls(Model model) {
        List<Poll> pollList = pollDao.findAll();
        model.addAttribute("pollList", pollList);
        return "polls";
    }

    @RequestMapping("/polls/{id}")
    String getPollById(@PathVariable Long id, Model model) {
        Poll p = pollDao.findById(id);
        model.addAttribute("poll", p);
        return "poll";
    }

    @RequestMapping("/answers")
    List<Answer> getAnswersByPollId(@RequestParam Long pollId) {
        return answerDao.getAllByPollId(pollId);
    }

    @RequestMapping("/answers/{id}")
    Answer getAnswerById(@PathVariable Long id) {
        return answerDao.findById(id);
    }
}
