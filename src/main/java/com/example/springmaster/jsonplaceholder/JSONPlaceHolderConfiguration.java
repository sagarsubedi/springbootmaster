package com.example.springmaster.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {

    @Bean("jsonplaceholder")
    CommandLineRunner runner(IJSONPlaceHolderClient ijsonPlaceHolderClient){
        return args -> {
            System.out.println();
            System.out.println("size() for Request to /posts");
            System.out.println(ijsonPlaceHolderClient.getPosts().size());
            System.out.println();
            System.out.println("Request to /posts/1");
            System.out.println(ijsonPlaceHolderClient.getPost(1));
        };
    }
}
