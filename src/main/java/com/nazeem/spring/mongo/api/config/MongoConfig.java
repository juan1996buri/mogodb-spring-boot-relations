package com.nazeem.spring.mongo.api.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configurable
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoClient mongoClient() {
        String host = env.getProperty("spring.data.mongodb.host");
        String port = env.getProperty("spring.data.mongodb.port");
        String database = env.getProperty("spring.data.mongodb.database");

        ConnectionString connectionString = new ConnectionString(String.format("mongodb://%s:%s/%s", host, port, database));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        String mongodb = env.getProperty("spring.data.mongodb.database");

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), mongodb );

        return mongoTemplate;
    }
}
