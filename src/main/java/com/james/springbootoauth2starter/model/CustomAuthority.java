package com.james.springbootoauth2starter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.james.springbootoauth2starter.enumeration.CustomAuthorityName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "authority")
@Table(name = "authority")
public class CustomAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Long authorityId;

    @Basic
    @Column(name = "authority", nullable = false, unique = true, length = 45)
    @Enumerated(EnumType.STRING)
    private CustomAuthorityName authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<CustomUser> users;

    public CustomAuthority() {
        ;
    }

    public CustomAuthority(CustomAuthorityName authority) {
        this.authority = authority;
    }

    @JsonIgnore
    public CustomAuthority(CustomAuthorityName authority, Set<CustomUser> customUsers) {
        this.authority = authority;
        this.users = users;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public String getAuthority() {
        return authority.name();
    }

    public void setAuthority(String authority) {
        this.authority = CustomAuthorityName.valueOf(authority);
    }

    public Set<CustomUser> getUsers() {
        return users;
    }

    public void setCustomUsers(Set<CustomUser> users) {
        this.users = users;
    }
}
