package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource securityDataSource;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(securityDataSource);
    User.UserBuilder users=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
        .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
        .withUser(users.username("louey").password("test123").roles("EMPLOYEE","MANAGER"))
        .withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
}
@Override
public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/api/leaders/**").hasRole("MANAGER")
                .antMatchers("/api/systems/**").hasRole("ADMIN")
                .and()

                .formLogin()
                .loginPage("/api/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                 .and()
                 .exceptionHandling().accessDeniedPage("/api/access-denied");
}

}
