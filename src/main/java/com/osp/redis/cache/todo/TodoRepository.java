package com.osp.redis.cache.todo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {

    @Cacheable("todo-user")
    List<Todo> findByUser(String user);

    List<Todo> findAllByStatus(Status status);
}
