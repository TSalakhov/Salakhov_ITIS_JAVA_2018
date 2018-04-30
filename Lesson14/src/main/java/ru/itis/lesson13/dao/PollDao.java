package ru.itis.lesson13.dao;

import ru.itis.lesson13.model.Poll;

import java.util.List;

public interface PollDao {
    Poll findById(Long id);
    List<Poll> findAll();
    Poll addNewPoll (String title);
}
