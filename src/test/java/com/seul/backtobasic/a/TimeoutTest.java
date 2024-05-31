package com.seul.backtobasic.a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {

    @Test
    @Timeout(1)
    void sleep2seconds() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void sleep40Mills() throws InterruptedException {
        Thread.sleep(40);
    }
}
