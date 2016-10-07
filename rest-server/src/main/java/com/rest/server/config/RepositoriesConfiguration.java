package com.rest.server.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@EnableJpaRepositories("com.rest.server.dao")
public class RepositoriesConfiguration {

	@Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(vendorAdapter);
        lef.setPackagesToScan("com.rest.server.entity");
        lef.afterPropertiesSet();
        return lef.getObject();
    }

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) throws Exception {
		return new JpaTransactionManager(emf);
	}
	
}
