package dh.example.webservice.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IndexControllerTest {

    @Autowired private TestRestTemplate restTemplate;


    @Test
    public void 메인페이지_테스트() {

        // when
        String body = this.restTemplate.getForObject("/", String.class);
        
        
        // then
        Assertions.assertThat(body).contains("Web Service Start!");
    }
}