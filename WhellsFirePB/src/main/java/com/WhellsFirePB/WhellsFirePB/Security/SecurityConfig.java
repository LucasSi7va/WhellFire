package com.WhellsFirePB.WhellsFirePB.Security;

import com.WhellsFirePB.WhellsFirePB.Model.MyAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MyAppUserService appUserService;

    @Autowired
    public SecurityConfig(MyAppUserService appUserService) {
        this.appUserService = appUserService;
    }




    @Bean
    public UserDetailsService userDetailsService() {
        return appUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin( httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                    httpForm.defaultSuccessUrl("/index");
                })
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/login", "/register", "/cadastro/**").permitAll();
                    registry.anyRequest().authenticated();
                })
                .build();
    }
}
