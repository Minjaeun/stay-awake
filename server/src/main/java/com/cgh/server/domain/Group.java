package com.cgh.server.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Getter
    private String name;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = User.class)
    private List<User> participants;
}
