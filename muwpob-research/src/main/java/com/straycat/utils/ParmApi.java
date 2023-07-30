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
        logger.info(Thread.currentThread()
                .getContextClassLoader().getResource("").toString());
        logger.info(Thread.currentThread()
                .getClass()
                .getClassLoader()
                .toString());
        String properPath = Thread.currentThread()
                .getContextClassLoader()
                .getResource("/config/" + fileName)
                .getPath();
        Properties props = new Properties();
        FileInputStream fio = null;
        try {
            fio = new FileInputStream(properPath);
            props.load(fio);
            for (Object propKey : props.keySet()) {
                String key = (String) propKey;
                String value = props.getProperty(key);
                parmMap.put(key, value);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            if (fio != null) {
                try {
                    fio.close();
                } catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
        }
    }
    /**
     * @description: 
     * @param parmKey: 
     * @return java.lang.String
     * @author: Overstars
     * @date: 2023/7/29 17:52
     */
    public static String getParameter(String parmKey) {
        if (parmKey != null || parmKey.isEmpty()) {
            init();
        }
        return parmMap.get(parmKey);
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
