package com.hendisantika.web.repository;

import com.hendisantika.web.entity.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/07/18
 * Time: 05.40
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryRepositoryTest {
    private final List<Person> persons = Arrays.asList(
            new Person("hendisantika", "hendisantika@test.com"),
            new Person("naruto", "naruto@test.com")
    );
    private final InMemoryRepository<Person, UUID> inMemoryRepository = new InMemoryRepository<>();

    @Before
    public void setup() {
        this.inMemoryRepository.save(persons);
    }

    @Test
    public void save() {
        InMemoryRepository<Person, UUID> inMemoryRepository = new InMemoryRepository<>();
        Person person = inMemoryRepository.save(persons.get(0));
        assertThat(person.getName()).isEqualTo("hendisantika");
        assertThat(person.getEmail()).isEqualTo("hendisantika@test.com");
    }

    @Test
    public void findOne() {
        InMemoryRepository<Person, UUID> inMemoryRepository = new InMemoryRepository<>();
        Person person = inMemoryRepository.save(persons.get(0));
        Person findOne = inMemoryRepository.findOne(person.getId());
        assertThat(findOne.getName()).isEqualTo("hendisantika");
        assertThat(findOne.getEmail()).isEqualTo("hendisantika@test.com");
    }

    @Test
    public void delete() {
        InMemoryRepository<Person, UUID> inMemoryRepository = new InMemoryRepository<>();
        Person person = inMemoryRepository.save(persons.get(0));
        inMemoryRepository.delete(person);
        assertThat(inMemoryRepository.findAll()).hasSize(0);
    }

    @Test
    public void deleteAll() {
        this.inMemoryRepository.deleteAll(persons);
        assertThat(this.inMemoryRepository.findAll()).hasSize(0);
    }

}