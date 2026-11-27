package com.starbank.recommendationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    // главная база данных
    @Primary
    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }

    // вторая база для правил, настройки из spring.rules-datasource
    @Bean(name = "rulesDataSource")
    @ConfigurationProperties(prefix = "spring.rules-datasource")
    public DataSource rulesDataSource() {
        return DataSourceBuilder.create().build();
    }
}