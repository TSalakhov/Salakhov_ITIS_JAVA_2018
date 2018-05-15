package ru.kpfu.itis.entertainmentadviser.model;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;


public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getRole() {
        return user.getRole();
    }

}
