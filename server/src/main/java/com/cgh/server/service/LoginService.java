package com.cgh.server.service;

import com.cgh.server.domain.Member;
import com.cgh.server.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean existsByNameAndPassword(String name, String password) {
        return memberRepository.existsByUsernameAndPassword(name, password);
    }

    public Optional<Member> findByNameAndPassword(String name, String password) {
        return memberRepository.findByUsernameAndPassword(name, password);
    }
}
