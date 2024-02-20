package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.model.Authorities;


public interface AuthorityRepo extends JpaRepository<Authorities, String>{

}
