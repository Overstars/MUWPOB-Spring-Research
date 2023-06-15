package com.straycat.action;

import com.straycat.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloAction {
    private static HelloService helloService;
    private static Logger logger = LoggerFactory.getLogger(HelloAction.class);
    public void hello() {
        String str = helloService.getHello();
        logger.info(str);
    }
}
