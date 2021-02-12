package com.example.auth.AuthApp.service.user;

import com.example.auth.AuthApp.data.model.AppUser;
import com.example.auth.AuthApp.data.model.Role;
import com.example.auth.AuthApp.data.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AppUserRepository appUserRepository;

    public AppUserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void registerUser(AppUser appUser) {
        appUser.setRoles(List.of(Role.ROLE_USER));
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
    }
}
