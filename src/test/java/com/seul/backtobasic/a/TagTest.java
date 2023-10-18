package com.seul.backtobasic.a;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("intergration")
public class TagTest {

    @Tag("very-slow")
    @Test
    void verySlow() {
        int result = someVerySlowOp();
        assertEquals(result, 0);
    }

    private int someVerySlowOp() {
        return 0;
    }
}
