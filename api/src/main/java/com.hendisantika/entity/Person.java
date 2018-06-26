package com.hendisantika.entity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/06/18
 * Time: 06.01
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private String email;

    Person() {

    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
