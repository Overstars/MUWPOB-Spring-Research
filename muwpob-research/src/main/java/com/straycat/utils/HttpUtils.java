package com.straycat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    // 公用的工具类是静态成员的集合，不需要实例化
    private HttpUtils() {
        throw new IllegalStateException("Utility class");
    }
    /*
     * https://blog.csdn.net/weixin_50637551/article/details/120804096
     * https://blog.csdn.net/qq_39463175/article/details/119684828
     * https://blog.csdn.net/HezhezhiyuLe/article/details/92395041
     * */
    /**
     * @description: 向指定url发送get请求的方法
     * @param url: 
     * @param param:
     * @param header:
     * @return java.lang.String
     * @author: Overstars
     * @date: 2023/7/25 21:53
     */
    public static String sendGet(String url, Map<String, Object> param, Map<String, String> header)  throws IOException {
        String result = "";
        BufferedReader in = null;
        String urlNameString = url + "?" + param;
        URL realUrl = new URL(urlNameString);

        URLConnection connection = realUrl.openConnection();
        // 设置超时时间
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(14000);
        // 设置通用的请求属性
        if (header != null) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                logger.info("header -> {} : {}" , entry.getKey(), entry.getValue());
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("Charsert", "UTF-8");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "");
        // 建立链接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            logger.info( "{} ---> {}", key, map.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应，设置utf8防止中文乱码
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        in.close();
        return result;
    }
    /**
     * @description: 向指定url发送post请求的方法
     * @param url:
     * @param param:
     * @param header:
     * @return java.lang.String
     * @author: Overstars
     * @date: 2023/7/26 0:50
     */
    public static String sendPost(String url, String param, Map<String, String> header) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
        //设置超时时间
        connection.setConnectTimeout(30000);
        connection.setReadTimeout(50000);
        // 设置通用的请求属性
        if (header!=null) {
            Iterator<Map.Entry<String, String>> it = header.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                logger.info("header -> {} : {}" , entry.getKey(), entry.getValue());
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        // 发送POST请求必须设置如下两行
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        out = new PrintWriter(connection.getOutputStream());
        // 发送请求参数
        out.print(param);
        // flush输出流的缓冲
        out.flush();
        final StringBuffer rspBuffer = new StringBuffer();
        if (connection.getResponseCode() == 200) {
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                rspBuffer.append(line);
            }
        } else {
            throw new RuntimeException("请求失败 状态码: " + connection.getResponseCode());
        }
        String result = rspBuffer.toString();
        out.close();
        in.close();
        return result;
    }
}
