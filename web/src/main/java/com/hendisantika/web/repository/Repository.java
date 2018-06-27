package com.hendisantika.web.repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/06/18
 * Time: 03.38
 * To change this template use File | Settings | File Templates.
 */
public interface Repository<T extends Entity<ID>, ID extends UUID> {

    List<T> findAll();

    T findOne(ID id);

    <S extends T> S save(S entity);

    <S extends T> List<S> save(Iterable<S> entities);

    void delete(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);
}