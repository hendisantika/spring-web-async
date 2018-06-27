package com.hendisantika.web.repository.ids;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/06/18
 * Time: 03.40
 * To change this template use File | Settings | File Templates.
 */
public class JdkIdGenerator implements IdGenerator {

    @Override
    public <T extends UUID> T getId() {
        return (T) UUID.randomUUID();
    }
}