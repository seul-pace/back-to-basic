package com.seul.backtobasic.chap09;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.seul.backtobasic.api.domain.test.CardNumberValidator;
import com.seul.backtobasic.api.enums.CardValidity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * HTTP 서버를 흉내낸다
 * 1. 테스트 실행 전에 WireMockServer를 시작한다. 실제 http 서버가 뜬다.
 * 2. 테스트에서 WireMockServer의 동작을 기술한다.
 * 3. http 연동을 수행하는 테스트를 실행한다.
 * 4. 테스트 실행 후에 WireMockServer를 중지한다.
 */
public class CardNumberValidatorTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(options().port(8089)); // port 지정
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void valid() {
        wireMockServer.stubFor(post(urlEqualTo("/card")) // 해당 경로로 post 요청하고
                .withRequestBody(equalTo("1234567890")) // 이런 값을 몸체로 전송할 때
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("ok"))); // ok를 리턴한다

        CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
        CardValidity validity = validator.validate("1234567890");
        assertEquals(CardValidity.VALID, validity);
    }

    @Test
    void timeout() {
        wireMockServer.stubFor(post(urlEqualTo("/card"))
                .willReturn(aResponse()
                        .withFixedDelay(5000)));

        CardNumberValidator validator = new CardNumberValidator("http://localhost:8089");
        CardValidity validity = validator.validate("1234567890");
        assertEquals(CardValidity.TIMEOUT, validity);
    }
}
