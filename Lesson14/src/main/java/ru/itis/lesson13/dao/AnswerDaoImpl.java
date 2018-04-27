package ru.itis.lesson13.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.lesson13.dao.mapper.AnswerRowMapper;
import ru.itis.lesson13.model.Answer;

import java.util.List;

@Component
public class AnswerDaoImpl implements AnswerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Answer> getAllByPollId(Long pollId) {
        String sqlQuery = "SELECT * FROM answer WHERE poll_id = ?";
        Object[] arr = {pollId};
        List<Answer> answers = jdbcTemplate.query(sqlQuery, arr, new AnswerRowMapper());
        return answers;
    }

    @Override
    public Answer findById(Long id) {
        String sqlQuery = "SELECT * FROM answer WHERE id = ?";
        Object[] arr = {id};
        return jdbcTemplate.queryForObject(sqlQuery, arr, new AnswerRowMapper());
    }
}
