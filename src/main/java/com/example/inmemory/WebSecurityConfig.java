package com.example.inmemory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated())
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/addTodo").hasRole("ADMIN")
                .anyRequest().authenticated()
			)
            .formLogin(null);
    }

    @Bean
	public UserDetailsService userDetailsService() {
        UserDetails user = 
			 User.builder()
             .username("user")
             .password("{noop}user")
             .roles("USER")
             .build();
             UserDetails admin = 
             User.builder()
             .username("admin")
             .password("{noop}admin")
             .roles("ADMIN")
             .build();
        return new InMemoryUserDetailsManager(user, admin);
 
	}
}