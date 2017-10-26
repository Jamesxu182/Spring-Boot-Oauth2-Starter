package com.james.springbootoauth2starter.service.impl;

import com.james.springbootoauth2starter.model.CustomUser;
import com.james.springbootoauth2starter.repository.CustomUserRepository;
import com.james.springbootoauth2starter.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomUserService implements CustomUserService {
    @Autowired
    private CustomUserRepository customUserRepository;

    @Override
    public CustomUser loadUserByUsername(String s) throws UsernameNotFoundException {
        return customUserRepository.findOneByUsername(s);
    }
}
