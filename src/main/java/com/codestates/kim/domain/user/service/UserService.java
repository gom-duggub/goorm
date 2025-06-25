package com.codestates.kim.domain.user.service;

import com.codestates.kim.config.jwt.JwtTokenProvider;
import com.codestates.kim.domain.user.User;
import com.codestates.kim.domain.user.repository.UserRepository;
import com.codestates.kim.exception.user.NotFoundUsernameException;
import com.codestates.kim.exception.user.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider tokenProvider;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new NotFoundUsernameException("존재하지 않는 유저입니다."));
        if (!Objects.equals(password, user.getPassword())) {
            throw new WrongPasswordException();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String access = tokenProvider.createToken(username);


        return access;
    }


}
