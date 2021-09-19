package com.prithila.personalfinancemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Prithila
 * @since 9/19/2021
 */

@SpringBootApplication
public class FinanceManagementApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FinanceManagementApp.class, args);
    }
}
