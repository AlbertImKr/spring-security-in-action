package com.practice.springsecurity.service;

import com.practice.springsecurity.auth.CustomUserDetails;
import com.practice.springsecurity.domain.User;
import com.practice.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> supplier = () -> new UsernameNotFoundException(
                "Problem during authentication!");

        User user = userRepository.findUserByUsername(username).orElseThrow(supplier);

        return new CustomUserDetails(user);
    }
}
