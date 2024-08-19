package edu.rpi.cs.csci4963.u24.wangn4.hw05.farmers_market.farmersmarketweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Farmers Market Web Application.
 * This class is responsible for bootstrapping the Spring Boot application.
 */
@SpringBootApplication
public class FarmersMarketWebApplication {

    /**
     * The main method that serves as the entry point for the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(FarmersMarketWebApplication.class, args);
    }
}