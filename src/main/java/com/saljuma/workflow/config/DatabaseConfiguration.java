package com.saljuma.workflow.config;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableReactiveNeo4jRepositories(
    basePackages = "com.saljuma.workflow.repository",
    includeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = ReactiveNeo4jRepository.class)
)
@EnableReactiveElasticsearchRepositories("com.saljuma.workflow.repository.search")
public class DatabaseConfiguration {

    @Bean(ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME)
    public ReactiveTransactionManager transactionManager(Driver driver, ReactiveDatabaseSelectionProvider databaseNameProvider) {
        return new ReactiveNeo4jTransactionManager(driver, databaseNameProvider);
    }
}
