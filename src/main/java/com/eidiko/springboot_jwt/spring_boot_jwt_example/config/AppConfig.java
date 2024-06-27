package com.eidiko.springboot_jwt.spring_boot_jwt_example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSource dataSource;
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(req -> req.requestMatchers("/home/users").hasRole("ADMIN"))
                .formLogin(Customizer.withDefaults())
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 =  User.builder().username("adil").password(passwordEncoder().encode("adil")).roles("ADMIN").build();
        System.out.println(user1);
         UserDetails user2=User.builder().username("akash") .password(passwordEncoder().encode("akash")).roles("ADMIN").build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

   // return  new InMemoryUserDetailsManager(user1,user2);
        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
