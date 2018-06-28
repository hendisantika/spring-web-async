package com.hendisantika.web.repository;


import com.hendisantika.web.repository.ids.IdGenerator;
import com.hendisantika.web.repository.ids.JdkIdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-web-async
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/06/18
 * Time: 03.39
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryRepository<T extends Entity<ID>, ID extends UUID> implements Repository<T, ID> {

    private final ConcurrentMap<ID, T> repos = new ConcurrentHashMap<>();
    private final IdGenerator idGenerator;

    public InMemoryRepository(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public InMemoryRepository() {
        this.idGenerator = new JdkIdGenerator();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(repos.values());
    }

    @Override
    public T findOne(ID id) {
        return repos.get(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S extends T> S save(S entity) {
        ID id = entity.getId();
        if (id == null) {
            id = idGenerator.getId();
        }
        entity.setId(id);
        repos.put(id, entity);
        return entity;
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        for (S entity : entities) {
            result.add(save(entity));
        }
        return result;
    }

    @Override
    public void delete(ID id) {
        repos.remove(id);
    }

    @Override
    public void delete(T entity) {
        repos.remove(entity.getId(), entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }
}
