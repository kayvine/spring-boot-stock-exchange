package com.switchfully.maven.exchange.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication combines the @Configuration, @EnableAutoConfiguration and @ComponentScan
 * annotations in 1 annotation. All 3 of these annotations are frequently used together in Spring Boot in the main class
 * (as is a best practice).
 * ---> @ComponentScan tells Spring to look for components in the specified (base)package.
 * It picks up (based on the basePackage) dependencies required by @Bean or @Inject
 * ---> @EnableAutoConfiguration tells Spring Boot to guess how to configure your Spring application. It does this based
 * on the dependencies (in Maven) you have included. E.g. If it detects you'll be using JPA, it will create the required
 * beans and it will search for @Entity annotated classed. This is a great asset of Spring Boot!
 * ---> @Configuration tells spring that this is a class that will declare 1 or more @Bean methods and that it may be processed
 * by the Spring Container to generate Bean definitions (at runtime).
 * The class defining the main method is usually a good candidate as the primary @Configuration
 * <p>
 * The CommandLineRunner is a Spring Boot interface which allows to inject to ApplicationContext and use it in the run method
 */

@SpringBootApplication(scanBasePackages = {"com.switchfully.maven.exchange"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
