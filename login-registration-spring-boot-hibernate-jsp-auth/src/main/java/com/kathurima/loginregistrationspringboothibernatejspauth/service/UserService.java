package com.kathurima.loginregistrationspringboothibernatejspauth.service;

import com.kathurima.loginregistrationspringboothibernatejspauth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}