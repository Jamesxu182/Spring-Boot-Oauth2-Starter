package com.james.springbootoauth2starter.repository;

import com.james.springbootoauth2starter.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findOneByUsername(String username);
}
