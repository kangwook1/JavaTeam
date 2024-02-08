package com.example.javateam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "category"
)
public class ReplyDao {
    @Id
    private long replyId;
    private LocalDateTime dateTime;
    private LocalDateTime regDate;
    private int grade;
    private String text;



}
