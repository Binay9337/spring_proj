package org.example.todoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class StudentController {

    private final TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoService.getTodoById(id);
    }
}
