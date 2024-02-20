package com.example.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.dto.UserDetailDto;
import com.example.security.model.Authorities;
import com.example.security.model.Users;
import com.example.security.repository.AuthorityRepo;
import com.example.security.repository.UsersRepo;

@Service
public class UsersAndAuthorityServiceImpl implements UsersAndAuthorityService {
	
	private UsersRepo usersRepository;
	private AuthorityRepo authoritiesRepository;
	
	public UsersAndAuthorityServiceImpl(UsersRepo usersRepository,AuthorityRepo authoritiesRepository) {
		this.authoritiesRepository =authoritiesRepository;
		this.usersRepository=usersRepository;
	}
	
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

	@Override
	public void addUserDetail(UserDetailDto userDetailDto) {
		// TODO Auto-generated method stub
		Users user= new Users();
		user.setUsername(userDetailDto.getUsername());
		String encryptedPass = passwordEncoder().encode(userDetailDto.getPassword());
		user.setPassword(encryptedPass);
		user.setEnabled(true);
		usersRepository.save(user);
		
		Authorities authorities = new Authorities();
		authorities.setUsername(userDetailDto.getUsername());
		authorities.setAuthority(userDetailDto.getAuthority());
		authoritiesRepository.save(authorities);
		
	}
    
}
