package com.example.auth.AuthApp.service;

import com.example.auth.AuthApp.data.model.AppUser;
import com.example.auth.AuthApp.data.model.Role;
import com.example.auth.AuthApp.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (appUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(appUser.getEmail(), appUser.getPassword(), getAuthorities(appUser.getRoles()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> authorities) {
        return getGrantedAuthority(authorities);
    }

    private List<GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(String.valueOf(role)));
        }

        return grantedAuthorities;
    }
}
