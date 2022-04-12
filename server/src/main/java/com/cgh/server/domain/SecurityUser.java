package com.cgh.server.domain;

import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {

    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public SecurityUser(Member member) {
        super(member.getUsername(), member.getPassword(), member.getAuthorities());
        this.member = member;
    }
}
