package com.straycat.muwpobresearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MuwpobResearchApplication {
    private static Logger logger = LoggerFactory.getLogger(MuwpobResearchApplication.class);
    public static void main(String[] args) {
        logger.info("Hello World!!!!");
        SpringApplication.run(MuwpobResearchApplication.class, args);
    }
}
