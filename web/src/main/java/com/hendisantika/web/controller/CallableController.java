package com.hendisantika.web.controller;

import com.hendisantika.web.entity.Person;
import com.hendisantika.web.generator.GeneratorPersons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/07/18
 * Time: 03.45
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class CallableController {

    private final GeneratorPersons generatorPersons;

    public CallableController(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @GetMapping("/callable")
    public Callable<List<Person>> persons() {
        return () -> {
            TimeUnit.SECONDS.sleep(2);
            return generatorPersons.getPersons();
        };
    }

    @GetMapping("/callable/{name}")
    public Callable<Person> person(@PathVariable String name) {
        return () -> {
            TimeUnit.SECONDS.sleep(2);
            return generatorPersons.getPerson(name);
        };
    }
}
