package com.example.kinoxpapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for your frontend URL (replace with your actual frontend URL)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:63343") // Replace with your frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow the necessary methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (cookies, etc.)
    }
}
