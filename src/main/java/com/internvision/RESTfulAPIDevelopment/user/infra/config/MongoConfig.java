package com.internvision.RESTfulAPIDevelopment.user.infra.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }


    @Bean
    public MongoTemplate mongoTemplate() {
        // Define o nome do banco usado pela aplicação
        return new MongoTemplate(mongoClient(), "internvision_db");
    }
}

