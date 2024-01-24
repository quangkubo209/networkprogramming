package com.example.demotest.repository;

import com.example.demotest.model.User;
import com.example.demotest.model.UserSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);



}

