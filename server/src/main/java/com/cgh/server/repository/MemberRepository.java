package com.cgh.server.repository;

import com.cgh.server.domain.Group;
import com.cgh.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);

    Optional<Member> findByUsername(String username);

    Optional<Member> findByUsernameAndPassword(String name, String password);

    List<Member> findMemberByGroup(Group group);

    boolean existsByUsernameAndPassword(String name, String password);

}
