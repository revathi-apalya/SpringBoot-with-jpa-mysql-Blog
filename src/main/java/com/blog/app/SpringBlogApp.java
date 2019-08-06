package com.blog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaAuditing
public class SpringBlogApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBlogApp.class, args);
    }
}
