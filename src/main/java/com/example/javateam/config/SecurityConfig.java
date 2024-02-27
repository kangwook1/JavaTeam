package com.example.javateam.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


/*
    1.요청
     -로그인 폼의 아이디와 비밀번호를 http body에 담아 authentication filter에 보낸다.
    2.토큰 생성
     -UsernamePasswordAuthenticationToken을 생성해 authentication manager에게 보낸다.
    3.토큰 처리 가능한 provider 탐색
     -AuthenticationProvider에게 토큰을 보내 인증을 맡긴다.
    4.인증 처리-1
     -userdetailService의 loadByUserName()을 통해 db에 있는 정보를 userDetails타입으로 가져온다.
    5.인증 처리-2
     -가져온 userDetails타입 객체의 password를 검증하고 성공하면 Authentication 객체에 담아 Manager을 거쳐 filter로 보낸다.
    6.handler 실행
     -SecurityContextHolder에 Authentication을 담고 AuthenticationSuccessHandler을 실행한다.(실패 시 AuthenticationFailureHandler 실행)
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        http
                .authorizeHttpRequests(authorizeRequest -> authorizeRequest
                        .requestMatchers(new MvcRequestMatcher(introspector, "/**")).permitAll()
                        //스프링 시큐리티는 자동으로 Role_접두어를 붙여준다.
                        .requestMatchers(new MvcRequestMatcher(introspector, "/**")).hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/user/login")//Get 형식으로 요청
                        .loginProcessingUrl("/user/login") //Post 형식으로 요청
                        .defaultSuccessUrl("/home")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .permitAll())
                .logout(logout-> logout
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/home")
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable);





        return http.build();

    }
}

