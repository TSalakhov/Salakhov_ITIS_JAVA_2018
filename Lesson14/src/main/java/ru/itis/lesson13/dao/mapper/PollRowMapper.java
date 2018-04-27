package ru.itis.lesson13.dao.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.lesson13.dao.AnswerDao;
import ru.itis.lesson13.model.Answer;
import ru.itis.lesson13.model.Poll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class PollRowMapper implements RowMapper<Poll> {
    @Autowired
    AnswerDao answerDao;

    @Override
    public Poll mapRow(ResultSet rs, int rowNum) throws SQLException {
        Poll poll = new Poll();
        poll.setId(rs.getLong("id"));
        poll.setTitle(rs.getString("title"));
        List<Answer> answers = answerDao.getAllByPollId(poll.getId());
        poll.setAnswers(answers);
        return poll;
    }
}
