package com.madbad.jwt.chat_jwt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "message")
@NoArgsConstructor
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser apiUser;

}
