package com.example.InMemorySecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
//AUTHENTICATION
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("nimisha").password("123").roles("USER")
                .and()
                .withUser("jenson").password("1234").roles("ADMIN");
    }
    //AUTHORISATION

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests().
                antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER").
                antMatchers("/forall").permitAll().and().formLogin();
    }

    @Bean
    @SuppressWarnings("deprecation")
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
