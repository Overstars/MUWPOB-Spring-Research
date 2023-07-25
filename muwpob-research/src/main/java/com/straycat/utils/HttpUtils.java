package com.straycat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /*
     * https://blog.csdn.net/weixin_50637551/article/details/120804096
     * https://blog.csdn.net/qq_39463175/article/details/119684828
     * https://blog.csdn.net/HezhezhiyuLe/article/details/92395041
     * */
    public static String sendGet(String url, Map<String, Object> param) {
        String result = "";
        BufferedReader in = null;
        String urlNameString = url + "?" + param;
        URL realUrl = new URL(urlNameString);

        URLConnection connection = realUrl.openConnection();
        connection.setConnectTimeout(5000)
        connection.setReadTimeout(14000);

        return result;
    }
}
