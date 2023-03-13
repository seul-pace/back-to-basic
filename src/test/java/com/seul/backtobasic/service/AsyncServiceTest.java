package com.seul.backtobasic.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncServiceTest {

    @Autowired
    AsyncService asyncService;

    @Test
    public void simpleTest() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("async");
        asyncService.simpleTestWithAsync();
        stopWatch.stop();

        stopWatch.start("not async");
        asyncService.simpleTestWithNotAsync();
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

}