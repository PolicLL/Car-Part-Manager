package com.example.unicorn.security;

import com.example.unicorn.filters.CsrfLoggerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.*;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.util.unit.DataSize;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource; // our database (right now - MySql)

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled " +
                        "FROM user_accounts WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role " +
                        "FROM user_accounts WHERE username = ?" )
                .passwordEncoder(bCryptPasswordEncoder); // decoding password

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        http.addFilterAfter(
                new CsrfLoggerFilter(),
                CsrfFilter.class);

        http.csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));

        http.authorizeRequests()
                .antMatchers("/api/warehouses").hasRole("ADMIN")
                .antMatchers("/" , "/**").permitAll()
                .and()
                .formLogin();



    }




}

