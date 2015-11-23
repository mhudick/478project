package controllers;

import models.User;

/**
 * Created by Phil on 11/3/2015.
 */
public class UserManager {
     User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
