package com.seul.backtobasic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    public void simpleTestWithNotAsync() throws InterruptedException {
        Thread.sleep(10);
    }

    @Async
    public void simpleTestWithAsync() throws InterruptedException {
        Thread.sleep(10);
    }

    @Async
    public void asyncTest(int i) {
        logger.info("async test: " + i);
    }
}
