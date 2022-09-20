package com.first.FirstWebApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
http.formLogin();

http.authorizeRequests()
        .mvcMatchers("/students/save").access("hasAnyAuthority('Admin')")
        .mvcMatchers("/students/delete").access("hasAnyAuthority('Admin')")
        .mvcMatchers("/students/update").access("hasAnyAuthority('Admin')")
        .mvcMatchers("/students/welcome").permitAll()
        .anyRequest().authenticated();
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
