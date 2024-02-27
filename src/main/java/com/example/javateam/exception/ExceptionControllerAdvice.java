package com.example.javateam.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 모든 컨트롤러가 실행하는 동안 발생할 수 있는 예외를 일괄적으로 처리하는 어노테이션
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ModelAndView handleCustomException(CustomException e){
        ModelAndView modelAndView=new ModelAndView("ErrorPage");
        modelAndView.addObject(e.getErrorCode().getMessage());
        return modelAndView;
    }
}
