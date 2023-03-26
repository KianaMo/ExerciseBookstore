package fi.haagahelia.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fi.haagahelia.bookstore.domain.UserDetailServiceImpl;
import fi.haagahelia.bookstore.domain.UserRepository;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				//.requestMatchers("/resources/**", "/signup", "/about").permitAll()
				//.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").defaultSuccessUrl("/booklist", true).permitAll()
				.and()
			.logout()
				.permitAll()
				.invalidateHttpSession(true)
				.and()
			.httpBasic();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(){
		userDetailsService = new UserDetailServiceImpl(repository);
		return userDetailsService;
	}
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(new
	BCryptPasswordEncoder());
	}
}
