package ru.itis.lesson13.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.lesson13.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AnswerRowMapper implements RowMapper<Answer> {
    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Answer answer = new Answer();
        answer.setId(rs.getLong("id"));
        answer.setText(rs.getString("text"));
        answer.setVotesCount(rs.getInt("votes_count"));
        return answer;
    }
}
