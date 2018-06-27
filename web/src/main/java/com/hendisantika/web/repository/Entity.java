package com.hendisantika.web.repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/06/18
 * Time: 03.37
 * To change this template use File | Settings | File Templates.
 */
public interface Entity<T extends UUID> {

    T getId();

    void setId(T id);
}
