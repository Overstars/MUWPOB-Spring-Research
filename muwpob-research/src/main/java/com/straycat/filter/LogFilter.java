package com.straycat.filter;

import com.straycat.utils.DBUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = servletRequest;
        HttpServletResponse response = servletResponse;
        long startTime = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } catch (IOException e) {
            logger.info(e.getMessage());
        } catch (ServletException e) {
            logger.info(e.getMessage());
        }
        String costTime = (System.currentTimeMillis() - startTime) + "";

    }
}
