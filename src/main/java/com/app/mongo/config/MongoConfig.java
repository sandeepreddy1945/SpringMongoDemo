package com.app.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value(value = "${application.server.name}")
    private String dbName;

    @Value(value = "${application.server.host}")
    private String dbHost;

    @Value(value = "${application.server.port}")
    private String dbPort;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MongoClient mongoClient() {
        return new MongoClient(dbHost, Integer.valueOf(dbPort));
    }
}