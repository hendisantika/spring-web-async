package com.hendisantika.web.service;

import com.hendisantika.web.entity.Person;
import com.hendisantika.web.generator.GeneratorPersons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/06/18
 * Time: 05.14
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AsyncService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final GeneratorPersons generatorPersons;

    public AsyncService(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @Async
    public ListenableFuture<List<Person>> asyncListenablePersons() {
        logger.info("asyncListenablePersons");
        return new AsyncResult<>(generatorPersons.getPersons());
    }

    @Async
    public CompletableFuture<List<Person>> asyncCompletablePersons() {
        logger.info("asyncCompletablePersons");
        return CompletableFuture.supplyAsync(generatorPersons::getPersons);
    }
}