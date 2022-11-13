package com.kathurima.loginregistrationspringboothibernatejspauth.repository;

import com.kathurima.loginregistrationspringboothibernatejspauth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername (String username);
}
