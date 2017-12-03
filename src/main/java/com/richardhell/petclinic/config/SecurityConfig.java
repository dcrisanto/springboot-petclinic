package com.richardhell.petclinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/com/**").hasAnyRole("ADMIN", "ASIS")
                .antMatchers("/gen/**").hasAnyRole("ADMIN", "ASIS")
                .antMatchers("/adm/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll();

        http.formLogin()
                .loginPage("/login")
                .successForwardUrl("/successLogin")
                .failureUrl("/login?error")
                .permitAll();

        http.logout().logoutSuccessUrl("/");
        http.sessionManagement().invalidSessionUrl("/");
        http.exceptionHandling().accessDeniedPage("/");

        http.csrf().disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
