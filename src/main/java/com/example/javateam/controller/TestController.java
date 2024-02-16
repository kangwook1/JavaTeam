package com.example.javateam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/HomePage")
    public String homepage(){
        return "HomePage";
    }
    @GetMapping("/loginpage")
    public String loginPage(){
        return "LoginPage";
    }
    @RequestMapping("/SignUp")
    public String signUp(){
        return "SignUpPage";
    }
    @RequestMapping("/template")
    public String template(){
        return "TemplateInformation";
    }
}
