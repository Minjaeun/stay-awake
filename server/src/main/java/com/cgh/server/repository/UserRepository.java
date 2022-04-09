package com.cgh.server.repository;

import com.cgh.server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByNameAndPassword(String name, String password);

    boolean existsByNameAndPassword(String name, String password);

}
