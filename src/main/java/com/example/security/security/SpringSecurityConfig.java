package com.example.security.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(
						authorizeRequests -> authorizeRequests
								.requestMatchers("/admin/**").hasRole("ADMIN")
								.requestMatchers("/user/**").hasRole("USER")
								.requestMatchers("/public/**").permitAll()
								.anyRequest().permitAll())
			.httpBasic(Customizer.withDefaults())
				.formLogin(
						formLogin -> formLogin
								.successHandler(new CustomAuthenticationSuccessHandler()))
//								.permitAll())
				.logout(logout -> logout.permitAll());
		return http.build();
	}
	
	   @Bean
       public UserDetailsManager userDetailsManager(DataSource dataSource) {
		   
		return new JdbcUserDetailsManager(dataSource);
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailManager(
//			@Value("${security.users.admin2.name}") String adminUsername,
//			@Value("${security.users.admin2.password}") String adminPassword,
//			@Value("${security.users.admin2.roles}") String adminRoles,
//			@Value("${security.users.user2.name}") String userUsername,
//			@Value("${security.users.user2.password}") String userPassword,
//			@Value("${security.users.user2.roles}") String userRoles
//			) {
//		
//		UserDetails admin = User.withUsername(adminUsername).password(passwordEncoder().encode(adminPassword))
//				.roles(adminRoles.split(","))
//				.build();
//		UserDetails user = User.withUsername(userUsername).password(passwordEncoder().encode(userPassword)).roles(userRoles)
//				.build();
//
////		System.out.println(admin);
////		System.out.println(user);
//		return new InMemoryUserDetailsManager(admin, user);
	//}
}
