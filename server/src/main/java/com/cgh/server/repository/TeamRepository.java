package com.cgh.server.repository;

import com.cgh.server.domain.Team;
import com.cgh.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
    @Override
    Optional<Team> findById(String s);

    //List<Group> findGroupByMember(Member member);

    List<Team> findByMember(Member member);

}
