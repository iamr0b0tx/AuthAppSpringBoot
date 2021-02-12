package com.example.auth.AuthApp.service.user;

import com.example.auth.AuthApp.data.model.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@RepositoryEventHandler
@Component
@Slf4j
public class AppUserEventHandler {
    @Autowired
    AppUserService appUserService;

    @HandleBeforeCreate
    public void handleBeforeCreate(AppUser appUser) {
        log.info("AppUser Object --> {}", appUser);
        appUserService.registerUser(appUser);
    }
}
