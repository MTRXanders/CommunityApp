package com.example.community.config;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@ComponentScan(basePackages = "com.example.community.config")
@EnableWebSecurity
public class SecurityConfig {
    
    // @Autowired
    // private CORSFilter corsFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Conventional method Bean for http.cors()
     */
    @Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.headers(headers -> headers.addHeaderWriter( new HeaderSecurity("Access-Controll-Allow-Origin: http://localhost:3000")));
        http.authorizeRequests()
            .antMatchers("/**").permitAll()
            .and().cors()
            .and().csrf()
            .and().httpBasic();
        return http.build();
    }
}
