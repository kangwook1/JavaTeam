package com.example.javateam.service;

import com.example.javateam.dto.TemplateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TemplateServiceTests {

    @Autowired
    private TemplateService service;

    // 조회 기능 테스트
    @Test
    public void testGet() {
        Long tno = 10L;

        TemplateDto templateDto = service.read(tno);

        System.out.println(templateDto);
    }


//    @Test
//    public void testRegister() {
//
//        TemplateDto templateDto = TemplateDto.builder()
//                .title("Sample Title.....")
//                .desc("Sample Description")
//                .gcs_path("http://gcs//image11")
//                .file_type("png")
//                .build();
//
////        System.out.println(service.register(templateDto));
//    }

}
