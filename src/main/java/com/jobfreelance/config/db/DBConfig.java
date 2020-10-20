/*package com.jobfreelance.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class DBConfig {
    @Bean(name="oracleDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource drouotDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="mysqlDatasource")
    @ConfigurationProperties(prefix = "jdbc.batch")
    public DataSource moniteurDatasource() {
        return DataSourceBuilder.create().build();
    }
}*/