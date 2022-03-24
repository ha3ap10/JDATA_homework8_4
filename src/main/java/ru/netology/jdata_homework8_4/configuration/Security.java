package ru.netology.jdata_homework8_4.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}qwe123").authorities("read", "write", "delete")
                .and()
                .withUser("user").password("{noop}pass").authorities("read")
                .and()
                .withUser("advancedUser").password("{noop}pass123").authorities("read", "write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and()
                .authorizeRequests().antMatchers("/persons/count").permitAll()
                .and()
                .authorizeRequests().antMatchers("/delete-all", "/delete-person").hasAuthority("delete")
                .and()
                .authorizeRequests().antMatchers("/create").hasAuthority("write")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
