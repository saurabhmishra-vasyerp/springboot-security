package com.example.security.dto;

import jakarta.persistence.Id;
import lombok.Data;


@Data
public class UserDetailDto {
	
	@Id
	private String username;
	private String password;
	private String authority;

}
