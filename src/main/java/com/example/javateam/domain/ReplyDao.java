package com.example.javateam.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "reply"
)
public class ReplyDao {
    @Id
    private long replyId;
    private LocalDateTime dateTime;
    private LocalDateTime regDate;
    private int grade;
    private String text;

    // 양방향 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDao user;

}
