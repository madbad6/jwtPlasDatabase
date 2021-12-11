package com.madbad.jwt.chat_jwt.repository;

import com.madbad.jwt.chat_jwt.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    Optional<ApiUser> findByUsername(String username);
}
