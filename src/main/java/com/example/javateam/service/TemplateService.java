package com.example.javateam.service;

import com.example.javateam.domain.TemplateDao;
import com.example.javateam.dto.TemplateDto;

public interface TemplateService {


//    Long register(TemplateDto dto);


    // 조회 처리
    TemplateDto read(Long tno);


    default TemplateDao dtoToEntity(TemplateDto dto) {
        TemplateDao entity = TemplateDao.builder()
                .template_id(dto.getTno())
                .title(dto.getTitle())
                .description(dto.getDesc())
                .gcs_path(dto.getGcs_path())
                .file_type(dto.getFile_type())
                .source(dto.getSource())
                .build();
        return entity;
    }


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
