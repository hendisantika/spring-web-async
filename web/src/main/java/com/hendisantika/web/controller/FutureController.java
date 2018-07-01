package com.hendisantika.web.controller;

import com.hendisantika.web.entity.Person;
import com.hendisantika.web.generator.GeneratorPersons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

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
public class FutureController {

    private final GeneratorPersons generatorPersons;

    public FutureController(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @GetMapping("/future")
    public CompletableFuture<List<Person>> future() {
        return CompletableFuture.supplyAsync(generatorPersons::getPersons);
    }

    @GetMapping("/completionStage")
    public CompletionStage<List<Person>> completionStage() {
        return CompletableFuture.supplyAsync(generatorPersons::getPersons);
    }
}
