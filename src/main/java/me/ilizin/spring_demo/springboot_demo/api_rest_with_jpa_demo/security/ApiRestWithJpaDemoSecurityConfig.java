package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// Since we've defined our users here, spring boot will not use the user/password from the application.properties file
@Configuration
public class ApiRestWithJpaDemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123") // {noop} indicates the password s stored as plain text
                .roles("USER") // roles might be any string
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary);
    }
}
