package com.example.javateam.dto.user;


import com.example.javateam.domain.UserDao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Member;

@Getter
@Setter
@AllArgsConstructor
public class UserSignUpReq{

    @NotBlank
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotBlank
    @Pattern(message = "비밀번호는 8자 이상의 영어, 숫자, 특수문자로 이루어져야 합니다."
            , regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;


    @NotBlank(message = "비어있으면 안됩니다.")
    private String nickname;


    public UserDao toEntity(){
        return UserDao.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
