package com.james.springbootoauth2starter.repository;

import com.james.springbootoauth2starter.model.CustomAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomAuthorityRepository extends JpaRepository<CustomAuthority, Long> {

}