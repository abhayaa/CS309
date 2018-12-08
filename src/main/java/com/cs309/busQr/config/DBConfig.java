package com.cs309.busQr.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SuppressWarnings("unused")
@Configuration
@EnableJpaRepositories("com.cs309.system")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("com.cs309.system")

public class DBConfig {

	@Resource
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean beanfac = new LocalContainerEntityManagerFactoryBean();
		beanfac.setDataSource(dataSource());
		beanfac.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		beanfac.setJpaProperties(getHibernateProperties());
		beanfac.setPackagesToScan(env.getRequiredProperty("spring.packagesToScan"));

		return beanfac;
	}



	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager man = new JpaTransactionManager();
		man.setEntityManagerFactory(entityManagerFactory().getObject());

		return man;
	}

	@Bean(destroyMethod = "")
	public DataSource dataSource() {
		BasicDataSource src = new BasicDataSource();
		src.setUrl(env.getRequiredProperty("spring.datasource.url"));
		src.setUsername(env.getRequiredProperty("spring.datasource.username"));
		src.setPassword(env.getRequiredProperty("spring.datasource.password"));
		src.setMinIdle(Integer.valueOf(env.getRequiredProperty("spring.datasource.tomcat.min-idle")));
		src.setMaxIdle(Integer.valueOf(env.getRequiredProperty("spring.datasource.tomcat.max-idle")));
		src.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));

		return src;
	}

	public Properties getHibernateProperties() {

		try {
			Properties prop = new Properties();
			InputStream strm = getClass().getClassLoader().getResourceAsStream("application.properties");
			prop.load(strm);

		} catch (IOException e) {
			throw new IllegalArgumentException("Error, cannot find hibernate.properties file");
		}

		return null;
	}

}
