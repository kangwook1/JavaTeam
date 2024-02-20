package com.example.javateam.controller;

import com.example.javateam.dto.TemplateDto;
import com.example.javateam.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/read")
@Log4j2
@RequiredArgsConstructor
public class TemplateInfoController {

    private final TemplateService service;

    @GetMapping("/{tno}")
    public String read(@PathVariable("tno") long tno, Model model) {

        log.info("tno:  " + tno);

        TemplateDto item = service.read(tno);

        model.addAttribute("item", item);

        return "TemplateInformation";

    }


}
