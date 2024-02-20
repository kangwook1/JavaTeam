package com.example.javateam.controller;


import com.example.javateam.dto.user.UserLoginReq;
import com.example.javateam.dto.user.UserSignUpReq;
import com.example.javateam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/login")
    public String login(){
        return "LoginPage";
    }

    @GetMapping(value = "/signup")
    public String signup(){
        return "SingUpPage";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("userLoginReq") UserLoginReq userLoginReq){
        return "SingUpSuccess";
    }

    @PostMapping(value = "/signup")
    public String signup(UserSignUpReq userSignUpReq){
        userService.signup(userSignUpReq);
        return "SingUpSuccess";
    }
}
