package com.seul.backtobasic.api.controller;

import com.seul.backtobasic.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/async")
    public void testAsync() {
        for(int i=0; i<1000; i++) {
            asyncService.asyncTest(i);
        }
    }
}
