package com.example.demotest.repository;

import com.example.demotest.model.UserSessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionsRepository extends JpaRepository<UserSessions, Long> {

    UserSessions findBySessionKey(String sessionKey);
}
