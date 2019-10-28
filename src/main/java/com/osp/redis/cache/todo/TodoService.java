package com.osp.redis.cache.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void create(Todo todo) {
        Assert.notNull(todo, "Todo cannot be null");

        todo.setStatus(Status.PENDENT);
        todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findByUser(String user) {
        return todoRepository.findByUser(user);
    }
}
