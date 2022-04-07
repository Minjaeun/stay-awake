package com.cgh.server.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Getter
    private String name;

    private Long group;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Record> records;

}
