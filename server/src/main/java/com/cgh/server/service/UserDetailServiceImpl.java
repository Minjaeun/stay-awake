package com.cgh.server.service;

import com.cgh.server.domain.Member;
import com.cgh.server.domain.SecurityUser;
import com.cgh.server.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    public UserDetailServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findMember = memberRepository.findByUsername(username);
        if (findMember.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        }
        return new SecurityUser(findMember.get());
    }
}
