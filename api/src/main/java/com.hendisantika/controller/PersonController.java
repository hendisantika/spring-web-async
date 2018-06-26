package com.hendisantika.controller;

import com.hendisantika.entity.Person;
import com.hendisantika.generator.GeneratorPersons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/18
 * Time: 06.08
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class PersonController {

    private final GeneratorPersons generatorPersons;

    public PersonController(GeneratorPersons generatorPersons) {
        this.generatorPersons = generatorPersons;
    }

    @GetMapping("/persons")
    public List<Person> persons() {
        return generatorPersons.getPersons();
    }
}