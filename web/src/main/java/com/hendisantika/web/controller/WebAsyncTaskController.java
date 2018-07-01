package com.hendisantika.web.controller;

import com.hendisantika.web.entity.Person;
import com.hendisantika.web.generator.GeneratorPersons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 02/07/18
 * Time: 03.49
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class WebAsyncTaskController {

    private final GeneratorPersons generatorPersons;

    public WebAsyncTaskController(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @GetMapping("/webAsyncTask")
    public WebAsyncTask<List<Person>> webAsyncTaskPerson() {
        return new WebAsyncTask<>(generatorPersons::getPersons);
    }
}