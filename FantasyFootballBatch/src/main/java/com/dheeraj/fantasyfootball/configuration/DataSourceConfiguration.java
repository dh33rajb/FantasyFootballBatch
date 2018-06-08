package com.dheeraj.fantasyfootball.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataSourceConfiguration {

	@Bean (name="mysqlDataSource")
	public DataSource mysqlDataSource() throws SQLException {
		final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://127.0.0.1:1234/FantasyFootball");
		dataSource.setUsername("dheeraj");
		dataSource.setPassword("dheerajdb");
		return dataSource;
	}

	@Bean
	public JdbcTemplate mysqlJdbcTemplate(@Qualifier("mysqlDataSource") final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
