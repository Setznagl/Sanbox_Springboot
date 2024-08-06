package com.example.multipledatasources.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = "com.example.multipledatasources.terceiroBanco.Repository",
        entityManagerFactoryRef = "terceiroEntityManager",
        transactionManagerRef = "terceiraTransactionManager"
)

@Configuration
public class TerceiroBancoConfig {


    @Bean
    @ConfigurationProperties(prefix = "terceiro.banco")
    public DataSourceProperties terceiroDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean terceiroEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(terceiroDataSourceProperties().initializeDataSourceBuilder().build());
        em.setPackagesToScan("com.example.multipledatasources.terceirobanco.model");


        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setShowSql(true);
        hibernateAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(hibernateAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager terceiraTransactionManager() {
        JpaTransactionManager terceiraTransactionManager = new JpaTransactionManager();
        terceiraTransactionManager.setEntityManagerFactory(terceiroEntityManager().getObject());

        return terceiraTransactionManager;
    }
}
