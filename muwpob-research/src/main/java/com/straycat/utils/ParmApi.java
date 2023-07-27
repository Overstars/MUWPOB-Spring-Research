package com.straycat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParmApi {
    protected static final Map<String, String> parmMap = new HashMap<>();
    protected static final Logger logger = LoggerFactory.getLogger("ParmApi");
    static String fileName;

    public static void init() {
        String properPath = Thread.currentThread().getContextClassLoader().getResource("/config/" + fileName).getPath();
        Properties props = new Properties();
        FileInputStream fio = null;
        try {
            fio = new FileInputStream(properPath);
        } catch () {
            
        }
    }
}
