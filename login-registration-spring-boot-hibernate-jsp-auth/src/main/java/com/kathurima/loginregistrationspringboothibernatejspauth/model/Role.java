package com.kathurima.loginregistrationspringboothibernatejspauth.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;
    private Set < User > users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //mappedBy indicates the entity is the inverse of the relationship.
    @ManyToMany(mappedBy = "roles")
    public Set < User > getUsers() {
        return users;
    }

    public void setUsers(Set < User > users) {
        this.users = users;
    }
}