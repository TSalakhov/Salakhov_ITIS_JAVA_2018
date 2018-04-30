package ru.itis.lesson13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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



@GetMapping("/createanswer")
String getAnserCreateForm(){
    return "answerCreateForm";
}

@PostMapping("/createanswer")
String createAnswer(@RequestParam String text,Long poll_id){
    System.out.println("User wants to create a new answer with title = " + text + " " + poll_id);
     answerDao.addNewAnswer(text,poll_id);
    return "redirect:/createanswer";
}


    @GetMapping("/create")
    String getPollCreateForm() {
        return "pollCreateForm";
    }

    @PostMapping("/create")
    String create(@RequestParam String title) {
        System.out.println("User wants to create a new poll with title = " + title);
        pollDao.addNewPoll(title);
        return "redirect:/create";
    }




    @PostMapping("/vote")
    String vote(Model model, @RequestParam(name = "answer") Long answerId) {
        Answer answer = answerDao.findById(answerId);
        answer.setVotesCount(answer.getVotesCount() + 1);
        answerDao.update(answer);
        return "redirect:/ListOfPolls";
    }


    @GetMapping("/ListOfPolls")
    String listPolls(Model model) {
  List<Answer> ListOfAnswers = answerDao.ShowAll();
    model.addAttribute("ListOfAnswers",ListOfAnswers);
    return "ShowAll";
    }


    @GetMapping("/polls")
    String getAllPolls(Model model) {
        List<Poll> pollList = pollDao.findAll();
        model.addAttribute("pollList", pollList);
        return "polls";
    }

    @GetMapping("/polls/{id}")
    String getPollById(@PathVariable Long id, Model model) {
        Poll p = pollDao.findById(id);
        model.addAttribute("poll", p);
        return "poll";
    }

    @GetMapping("/answers")
    List<Answer> getAnswersByPollId(@RequestParam Long pollId) {
        return answerDao.getAllByPollId(pollId);
    }

    @GetMapping("/answers/{id}")
    Answer getAnswerById(@PathVariable Long id) {
        return answerDao.findById(id);
    }
}
