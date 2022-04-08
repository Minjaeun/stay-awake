package com.cgh.server.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Getter
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Group.class)
    private List<Group> groups = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Subject.class)
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Record.class)
    private List<Record> records = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> friends = new ArrayList<>();

}
