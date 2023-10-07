package com.seul.backtobasic.chap09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT // 임의의 포트를 사용해서 내장 서버를 구동
)
public class UserApiE2ETest {

    @Autowired
    private TestRestTemplate restTemplate; // 스프링부트가 테스트 목적으로 제공하는 것, 내장 서버에 연결하는 RestTemplate

    @Test // TODO 이거 대체 어떻게 하는 거야?
    void weakPwResponse() {
        String reqBody = "{\"id\": \"id\", \"pw\": \"123\", \"email\": \"a@a.com\"}";
        RequestEntity<String> request = RequestEntity.post(URI.create("/users"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(reqBody);

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("WeakPasswordException"));
    }
}
