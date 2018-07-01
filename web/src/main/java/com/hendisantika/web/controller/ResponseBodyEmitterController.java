package com.hendisantika.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/07/18
 * Time: 03.48
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class ResponseBodyEmitterController {

    @GetMapping("/emitter")
    public ResponseBodyEmitter emitter() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                emitter.send("<p> Stream index : " + i + " </p>");
                Thread.sleep(100);
            }
            emitter.complete();
            return null;
        });
        return emitter;
    }
}