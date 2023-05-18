package com.practice.springsecurity.config;

import com.practice.springsecurity.auth.AuthenticationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class AuthConfig {

    private final AuthenticationProviderService authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin().defaultSuccessUrl("/main",true)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(authenticationProvider);
        return httpSecurity.build();
    }
}
