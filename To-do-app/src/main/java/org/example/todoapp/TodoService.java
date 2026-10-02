package org.example.todoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
private final TodoRepository todoRepository;
public Todo createTodo(Todo todo){
    return todoRepository.save(todo);
}
public List<Todo> getTodos(){
    return todoRepository.findAll();
}
public Todo getTodoById(int id){
    return todoRepository.findById(id).orElseThrow();
}
public Todo updateTodo(Todo todo){
  Todo existingTodo = getTodoById(todo.getId());
  existingTodo.setTask(todo.getTask());

  existingTodo.setComplete_task(todo.getComplete_task());
  return  todoRepository.save(existingTodo);
}

}
