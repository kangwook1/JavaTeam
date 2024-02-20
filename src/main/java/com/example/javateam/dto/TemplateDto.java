package com.example.javateam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TemplateDto {

    private Long tno;
    private String title;
    private String desc;
    private String gcs_path;
    private String file_type;
    private String source;
    private LocalDateTime regDate, modDate;




}
