package ru.itis.project.model;

import java.util.List;

public class User {
    private Long  id;
    private Long password;
    private String name;
    private String secondName;
    private String city;
    private List<Tag> userTags;

    public User() {
    }

    public User(Long id, Long password, String name, String secondName, String city, List<Tag> userTags) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.city = city;
        this.userTags = userTags;
    }

    public List<Tag> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<Tag> userTags) {
        this.userTags = userTags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
