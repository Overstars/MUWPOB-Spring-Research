package com.straycat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ParmApi {
    protected static final Logger logger = LoggerFactory.getLogger("ParmApi");
    protected static Map<String, String> parmMap = new HashMap<>();
    static String fileName = "application.properties";

    public static void init() {
        logger.info(Thread.currentThread()
                .getContextClassLoader().getResource("").toString());
//        logger.info(Thread.currentThread()
//                .getClass()
//                .getClassLoader()
//                .toString());
        String properPath =
                Thread.currentThread()
                .getContextClassLoader()
                .getResource("config/" + fileName)
                .getPath();
        logger.info("加载地址properPath:{}", properPath);
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
            logger.info("parmMap加载完毕:{}", parmMap.toString());
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
        if (parmKey != null && parmMap.isEmpty()) {
            logger.info("parmKey未加载,且parmKey有值,加载parmKey..");
            init();
        }
        return parmMap.get(parmKey);
    }
    public static void main(String[] args) {
        try {
            logger.info("开始测试:getParameter");
            init();
            logger.info("init完毕");
            logger.debug("decrisption: {}", getParameter("description"));
        }
        catch (Exception e) {
            logger.info("测试ParmApi异常：{}", e.getMessage());
        }
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
