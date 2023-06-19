package com.straycat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;

public class DBUtility {
    private static final Logger logger = LoggerFactory.getLogger(DBUtility.class);

    public static Map<String, Object> query(Context context) {
        try {
            Map<String, Object> ret = new HashMap<>();
            return ret;
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw e;
        }
//        return null;
    }
}
