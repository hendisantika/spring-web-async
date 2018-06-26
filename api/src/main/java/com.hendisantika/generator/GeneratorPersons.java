package com.hendisantika.generator;

import com.hendisantika.entity.Person;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/18
 * Time: 06.07
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GeneratorPersons {

    private final List<Person> persons = Arrays.asList(
            new Person("hendisantika", "hendisantika@test.com"),
            new Person("naruto", "naruto@test.com"));

    public List<Person> getPersons() {
        return persons;
    }

    public Person getPerson(String name) {
        return persons
                .stream()
                .filter(person -> person.getName().equals(name))
                .findFirst().orElse(null);
    }
}