package com.jdbc.test;

import com.jdbc.ConfigBeans;
import com.jdbc.api.Student;
import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        /*
        * Criar Bean via XML 'beans.xml' e pegar o seu Contexto
        * */
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        /*
         * Criar Bean via classe de configuração 'ConfigBeans.class' e pegar o seu Contexto
         * */
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBeans.class);

        System.out.println("application context loaded...");
        StudentDAO studentDAO = context.getBean("studentDaoImplObject", StudentDAOImpl.class);

        Student student1 = new Student();
        student1.setRoolNo(5);
        student1.setName("Julia");
        student1.setAddress("Quixeré");

        studentDAO.insert(student1);
    }
}
