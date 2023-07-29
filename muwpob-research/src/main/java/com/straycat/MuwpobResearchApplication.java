package com.straycat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class MuwpobResearchApplication {
    private static Logger logger = LoggerFactory.getLogger(MuwpobResearchApplication.class);
    public static void main(String[] args) {
        logger.info("Hello World!!!!");
        Map<String, Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        map.put("list1", list);
        Boolean flag1 = map instanceof Map;
        Boolean flag2 = map.get("list1") instanceof List;
        logger.info(flag1.toString());
        logger.info(flag2.toString());
        SpringApplication.run(MuwpobResearchApplication.class, args);
    }
}
