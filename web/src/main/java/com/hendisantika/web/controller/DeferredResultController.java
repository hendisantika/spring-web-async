package com.hendisantika.web.controller;

import com.hendisantika.web.entity.Person;
import com.hendisantika.web.generator.GeneratorPersons;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/07/18
 * Time: 03.46
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class DeferredResultController {

    private final Queue<DeferredResult<List<Person>>> personsQueue = new ConcurrentLinkedQueue<>();

    private final GeneratorPersons generatorPersons;

    public DeferredResultController(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @GetMapping("/deferred")
    public DeferredResult<List<Person>> persons() {
        DeferredResult<List<Person>> result = new DeferredResult<>();
        personsQueue.add(result);
        return result;
    }

    @Scheduled(fixedRate = 2000)
    public void processQueues() {
        for (DeferredResult<List<Person>> result : this.personsQueue) {
            result.setResult(generatorPersons.getPersons());
            this.personsQueue.remove(result);
        }
    }
}