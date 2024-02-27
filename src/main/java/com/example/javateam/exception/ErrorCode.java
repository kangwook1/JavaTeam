package com.example.javateam.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
/*
    Enum은 본질적으로 불변이기 때문에 멤버 변수들 또한 final로 지정해줘야 한다.
    상수에 값을 지정할 때, 그에 맞는 멤버 필드와 생성자를 선언해야 한다, getter도 있으면 좋다.
    Enum은 생성자가 private이다.
 */
public enum ErrorCode {

    DUPLICATED_EMAIL("이미 사용중인 이메일입니다.");
    private final String message;
}
