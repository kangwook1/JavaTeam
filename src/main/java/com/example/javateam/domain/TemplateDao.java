package com.example.javateam.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "template")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateDao extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long template_id;

    @Column(length = 50, nullable = false)
    private String title; // 템플릿 제목

    @Column(length = 255, nullable = false)
    private String gcs_path;

    @Column(length = 50, nullable = false)
    private String file_type;

    @Column(length = 50)
    private String description;

    @Column(length = 50)
    private String source;

    // ManytoOne 연관관계 제정






}
