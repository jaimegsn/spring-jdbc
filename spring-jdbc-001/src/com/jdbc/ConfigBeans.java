package com.jdbc;

import com.jdbc.dao.StudentDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ConfigBeans {

    @Bean
    public DriverManagerDataSource dataSource(){
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/school",
                "docker",
                "docker");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public StudentDAOImpl studentDaoImplObject(){
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        studentDAO.setJdbcTemplate(jdbcTemplate());
        return studentDAO;
    }
}
