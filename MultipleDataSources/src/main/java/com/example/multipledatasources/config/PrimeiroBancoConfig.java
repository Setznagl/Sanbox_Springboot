package com.example.multipledatasources.config;

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
        basePackages = "com.example.multipledatasources.primeiroBanco.Repository",
        entityManagerFactoryRef = "primeiraEntityManager",
        transactionManagerRef = "primeiraTransactionManager"
)

@Configuration
public class PrimeiroBancoConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "primeiro.banco")
    public DataSourceProperties primeiroDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean primeiraEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primeiroDataSourceProperties().initializeDataSourceBuilder().build());
        em.setPackagesToScan("com.example.multipledatasources.primeirobanco.model");


        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setShowSql(true);
        hibernateAdapter.setGenerateDdl(true);

        em.setJpaVendorAdapter(hibernateAdapter);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager primeiraTransactionManager() {
        JpaTransactionManager primeiraTransactionManager = new JpaTransactionManager();
        primeiraTransactionManager.setEntityManagerFactory(primeiraEntityManager().getObject());

        return primeiraTransactionManager;
    }
}
