package com.madbad.jwt.chat_jwt.repository;

import com.madbad.jwt.chat_jwt.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {
    List<MessageModel> findAllByOrderByCreateDateAsc();
}
