package com.jdbc.dao;

import com.jdbc.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

/*    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/school");
        dataSource.setUsername("docker");
        dataSource.setPassword("docker");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }*/

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT VALUES (?,?,?)";

        /*
         * Criamos um array de objetos para pegar os valores que iremos inserir no banco
         * Não criamos um array de Strings, Integer ou de algum tipo especifico porque
         * Os tipos de dado variam em um objeto e o array só pode ser de um tipo
         * */
        Object[] args = {student.getRoolNo(), student.getName(), student.getAddress()};

        int noOfRowInserted = jdbcTemplate.update(sql, args);
        System.out.println("No of row inserted is " + noOfRowInserted);
    }
}
