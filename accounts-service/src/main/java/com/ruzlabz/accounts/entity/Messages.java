package com.ruzlabz.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "message_code")
    private String messageCode;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "message_local")
    private String messageLocal;

}
