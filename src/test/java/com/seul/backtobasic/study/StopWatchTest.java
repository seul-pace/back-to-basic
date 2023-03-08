package com.seul.backtobasic.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@SpringBootTest
public class StopWatchTest {

    @Test
    void stop_watch_test() {
        StopWatch stopWatch = new StopWatch("Print Test");

        int sum = 0;

        stopWatch.start("Print");
        for(int i=0; i<10; i++) {
            sum += i;
            System.out.println(i);
        }
        stopWatch.stop();

        sum = 0;

        stopWatch.start("Not Print");
        for(int i=0; i<10; i++) {
            sum += i;
        }
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

}
