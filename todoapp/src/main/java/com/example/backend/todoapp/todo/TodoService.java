package com.example.backend.todoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {

    List<Todo> todos = Arrays.asList(new Todo(1, "Rishabh", "Learn Spring Boot", LocalDate.now().plusDays(10), false),
            new Todo(1, "Tom", "Learn Devops", LocalDate.now().plusDays(20), false),
            new Todo(1, "Green", "Learn Reactjs", LocalDate.now().plusDays(30), false));

    public List<Todo> retreiveAllTodos() {
        return todos;
    }

    public List<Todo> findTodosByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }
}
