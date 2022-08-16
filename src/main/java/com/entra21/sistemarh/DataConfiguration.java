package com.entra21.sistemarh;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Configuração do Banco de Dados
 * criado em 16/08/2022
 * 
 * autor: Ramon Casagrande
 * 
 */

@Configuration
public class DataConfiguration {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sysRH?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("josimara");

        return dataSource;
    }

    //Configuração padrão de BD
    @Bean
    public JpaVendorAdapter JpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
        adapter.setPrepareConnection(true);
        return adapter;
        
    }
    
}
