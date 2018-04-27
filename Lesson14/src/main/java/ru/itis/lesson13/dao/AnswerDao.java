package ru.itis.lesson13.dao;

import ru.itis.lesson13.model.Answer;

import java.util.List;

public interface AnswerDao {
    List<Answer> getAllByPollId(Long PollId);
    Answer findById(Long id);
}
