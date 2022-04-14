package com.cgh.server.repository;

import com.cgh.server.domain.Group;
import com.cgh.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    @Override
    Optional<Group> findById(String s);

    List<Group> findByMember(Member member);

}
