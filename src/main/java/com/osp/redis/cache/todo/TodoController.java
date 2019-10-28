package com.osp.redis.cache.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Todo todo) {
        todoService.create(todo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("{user}")
    public ResponseEntity<List<Todo>> getByUser(@PathVariable String user) {
        return ResponseEntity.ok(todoService.findByUser(user));
    }
}
