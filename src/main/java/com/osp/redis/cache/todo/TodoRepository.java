package com.osp.redis.cache.todo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    @Cacheable(cacheNames = "todo-user", key = "#user")
    List<Todo> findByUser(String user);

    List<Todo> findAllByStatus(Status status);

    @Override
    @CacheEvict(cacheNames = "todo-user", key = "#todo.user")
    Todo save(Todo todo);
}
