package com.seul.backtobasic.study;

import com.seul.backtobasic.study.interfacestudy.Worker;
import org.junit.jupiter.api.Test;

public class WorkerTest {

    @Test
    void test() {
        Worker worker = new Worker("David", 23, Worker.MALE);
        System.out.println(worker.getInformation() + ", " + worker.getSex());
    }
}
