package com.example.javateam.service;

import com.example.javateam.domain.TemplateDao;
import com.example.javateam.dto.TemplateDto;

public interface TemplateService {


    // 조회 처리
    TemplateDto read(Long tno);


    default TemplateDto entityToDto(TemplateDao entity) {

        TemplateDto dto = TemplateDto.builder()
                .tno(entity.getTemplate_id())
                .title(entity.getTitle())
                .desc(entity.getDescription())
                .gcs_path(entity.getGcs_path())
                .file_type(entity.getFile_type())
                .source(entity.getSource())
                .build();
        return dto;
    }


}
