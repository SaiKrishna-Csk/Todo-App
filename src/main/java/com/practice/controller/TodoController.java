package com.practice.controller;

import com.practice.model.Todo;
import com.practice.repository.TodoRepository;
import com.practice.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    ITodoService todoService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/todos")
    public String allTodos(ModelMap map,
                           @RequestParam(value="page",defaultValue="1") int page){
        map.put("todos",todoService.listTodos(page-1));
        map.put("currentPage",page);
        return "listTodos";
    }

    @GetMapping("/addTodo")
    public String addTodo(ModelMap map){
        map.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodoPost(Todo todo){
        todoRepository.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/updateTodo")
    public String updateTodo(@RequestParam("id") String id, ModelMap map){
        map.addAttribute("todo",todoRepository.findById(Integer.parseInt(id)));
        return "addTodo";
    }

    @GetMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") String id){
        todoRepository.deleteById(Integer.parseInt(id));
        return "redirect:/todos";
    }
}
