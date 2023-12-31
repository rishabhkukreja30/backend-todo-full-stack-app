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

    public Todo findTodo(String username, int id) {
        List<Todo> todoList = findTodosByUsername(username);
        return todoList.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void deleteById(int id) {
        Todo deletedToodo = todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
        todos.remove(deletedToodo);
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
