package com.cgh.server.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Member.class)
    private List<Member> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
