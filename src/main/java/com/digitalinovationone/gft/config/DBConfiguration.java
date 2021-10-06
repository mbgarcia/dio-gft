package com.digitalinovationone.gft.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(DBConfiguration.class);
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String devDataBaseConnection() {
		return buildDatabaseConnection();
	}
	
	@Profile("prod")
	@Bean
	public String prodDataBaseConnection() {
		return buildDatabaseConnection();
	}
	
	private String buildDatabaseConnection() {
		logger.info("DB connection for [{}]", activeProfile);
		logger.info(driverClassName);
		logger.info(url);
		return "DB connection for " + activeProfile;
	}
}
