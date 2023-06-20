package com.straycat.interceptor;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingException;

public class ContextParmInterceptor {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    public void onRequest(Context context) {
        context
    }
    public void onResponse(Context context) throws NamingException {
        logger.info("交易结束{0}", context.getNameInNamespace());
    }
}
