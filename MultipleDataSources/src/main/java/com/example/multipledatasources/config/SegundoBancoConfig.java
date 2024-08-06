package com.example.multipledatasources.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = "com.example.multipledatasources.segundoBanco.Repository",
        entityManagerFactoryRef = "segundaEntityManager",
        transactionManagerRef = "segundaTransactionManager"
)

@Configuration
public class SegundoBancoConfig {

    @Qualifier("segundoDataSourceProperties")
    @Bean
    @ConfigurationProperties(prefix = "segundo.banco")
    public DataSourceProperties segundoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean segundaEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(segundoDataSourceProperties().initializeDataSourceBuilder().build());
        em.setPackagesToScan("com.example.multipledatasources.segundobanco.model");


        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setShowSql(true);
        hibernateAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(hibernateAdapter);

        return em;
    }

    @Qualifier("segundoDataSourceProperties")
    @Bean
    public PlatformTransactionManager segundaTransactionManager() {
        JpaTransactionManager segundaTransactionManager = new JpaTransactionManager();
        segundaTransactionManager.setEntityManagerFactory(segundaEntityManager().getObject());

        return segundaTransactionManager;
    }
}
