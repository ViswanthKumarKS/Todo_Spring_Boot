package com.viswanth.Controller;


import com.viswanth.Model.Todo;
import com.viswanth.repostiory.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo/all")
    public List<Todo> getTodo() {
        return todoRepository.findall();

    }
    @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoRepository.insert(todo);
    }

    @PutMapping("/todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        return todoRepository.update(todo);
    }
    @DeleteMapping("/todo/{id}")
    public List<Todo> deleteTodo(@PathVariable int id){
        return todoRepository.delete(id);
    }


}
