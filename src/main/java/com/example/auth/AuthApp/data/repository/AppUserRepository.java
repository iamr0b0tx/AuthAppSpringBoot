package com.example.auth.AuthApp.data.repository;

import com.example.auth.AuthApp.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
//    AppUser findByUsername(String username);
}
