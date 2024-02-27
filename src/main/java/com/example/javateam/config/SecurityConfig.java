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
                        .loginPage("/user/login")
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

