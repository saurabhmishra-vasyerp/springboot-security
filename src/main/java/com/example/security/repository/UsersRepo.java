package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.model.Users;

public interface UsersRepo extends JpaRepository<Users, String>{

}
