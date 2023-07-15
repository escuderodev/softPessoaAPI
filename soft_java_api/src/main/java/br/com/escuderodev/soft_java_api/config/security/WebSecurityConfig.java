package br.com.escuderodev.soft_java_api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    configurações de autenticação e  autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/pessoa/**").permitAll()
                .antMatchers(HttpMethod.POST, "/pessoa").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/pessoa").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/pessoa").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/usuario/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/pessoa").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/pessoa").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/pessoa").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

//    login via banco de dados
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

//    encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}