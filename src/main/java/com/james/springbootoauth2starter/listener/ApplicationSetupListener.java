package com.james.springbootoauth2starter.listener;

import com.james.springbootoauth2starter.enumeration.CustomAuthorityName;
import com.james.springbootoauth2starter.model.CustomAuthority;
import com.james.springbootoauth2starter.model.CustomUser;
import com.james.springbootoauth2starter.repository.CustomAuthorityRepository;
import com.james.springbootoauth2starter.repository.CustomUserRepository;
import com.james.springbootoauth2starter.service.impl.DefaultCustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ApplicationSetupListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    CustomAuthorityRepository customAuthorityRepository;

    @Autowired
    CustomUserRepository customUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    DefaultCustomUserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        CustomAuthority userAuthority = new CustomAuthority(CustomAuthorityName.ROLE_USER);
        CustomAuthority adminAuthority = new CustomAuthority(CustomAuthorityName.ROLE_ADMIN);

        customAuthorityRepository.save(userAuthority);
        customAuthorityRepository.save(adminAuthority);

        Set<CustomAuthority> authorities = new HashSet<>();
        authorities.add(userAuthority);
        authorities.add(adminAuthority);

        customUserRepository.save(new CustomUser("Yifan", bCryptPasswordEncoder.encode("123456"), true, authorities));

        CustomUser customUser = userService.loadUserByUsername("Yifan");
    }
}
