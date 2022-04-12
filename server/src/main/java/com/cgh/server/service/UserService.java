package com.cgh.server.service;

import com.cgh.server.domain.Member;
import com.cgh.server.domain.Role;
import com.cgh.server.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        memberRepository.save(new Member("admin", new BCryptPasswordEncoder().encode("1234"), Role.ROLE_ADMIN));
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberRepository.findAll());
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member;
        if (memberRepository.findByUsername(username).isPresent()) {
            member = memberRepository.findByUsername(username).get();
        } else {
            throw new UsernameNotFoundException("user not found");
        }
        return member;
    }
}
