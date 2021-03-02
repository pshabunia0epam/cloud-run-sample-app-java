package com.example.gpsolab;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** This class serves as an entry point for the Spring Boot app. */
@Log
@SpringBootApplication
public class SampleApplication {

  public static void main(final String[] args) {
    new SpringApplication(SampleApplication.class).run(args);
    log.info("The application has started successfully and is listening for HTTP requests on " + System.getenv().get("server.port"));
  }
}
