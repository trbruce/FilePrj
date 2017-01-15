package com.yla.configuration;

/**
 * Created by Yusuf on 05/01/2017.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("yusuf").password("Technobrainsm1").roles("USER");
        auth.inMemoryAuthentication().withUser("levent").password("Technobrainsm1").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("aksun").password("Technobrainsm1").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home","/upload.do","/convert.do","/download.do").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                //.anyRequest().authenticated()
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login.do")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf().disable()
                .exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}