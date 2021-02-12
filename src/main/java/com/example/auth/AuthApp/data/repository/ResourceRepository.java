package com.example.auth.AuthApp.data.repository;

import com.example.auth.AuthApp.data.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "resource")
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
