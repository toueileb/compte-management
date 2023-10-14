package org.sid.comptemanagement;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

@SpringBootApplication
public class CompteManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteManagementApplication.class, args);
    }

}
