package ru.itis.lesson13.model;

public class Answer {
    private Long id;
    private String text;
    private Integer votesCount;

    public Answer() {
    }

    public Answer(Long id, String text, Integer votesCount) {
        this.id = id;
        this.text = text;
        this.votesCount = votesCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }
}
