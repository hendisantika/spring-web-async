package com.hendisantika.web.controller;

import com.hendisantika.web.testing.Testing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/07/18
 * Time: 05.44
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CallableControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void callable() throws InterruptedException {
        try (Testing testing = new Testing(100, 100)) {
            testing.run(() -> template.getForEntity("/callable", String.class));
            assertThat(testing.getTotalTimeMillis()).isLessThan(3000);
            System.out.println(testing.getTotalTimeMillis());
            assertThat(testing.getRealCount()).isEqualTo(100);
            assertThat(testing.totalActionCount()).isEqualTo(100);
        }
    }
}