/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.bacon.config;

/**
 *
 * @author jean
 */
import com.restaurante.bacon.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersonalService personalService;
    
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    
    //configura Spring Security para la autorización tanto de controladores como de 
    //archivos en el proyecto 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/css/vertical-layout-light/style.css",
                        "/vendors/mdi/css/materialdesignicons.min.css",
                        "/vendors/flag-icon-css/css/flag-icon.min.css",
                        "/vendors/css/vendor.bundle.base.css",
                        "/images/favicon.png",
                        "/images/logo.svg",
                        "/vendors/js/vendor.bundle.base.js",
                        "/js/off-canvas.js",
                        "/js/hoverable-collapse.js",
                        "/js/template.js",
                        "/js/settings.js",
                        "/js/todolist.js",
                        "/fonts/Roboto/**",
                        "/custom/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    
    //encripta una text 
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    //La dependiencia de autentificación de Spring Security carga y compara la contraseña ingresada
    //con la contraseña en la base de datos 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(personalService).passwordEncoder(bcrypt);
    }

}
