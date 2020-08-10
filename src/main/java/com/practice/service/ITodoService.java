package com.practice.service;

import com.practice.model.Todo;
import com.practice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITodoService {

    public List<Todo> listTodos();
}
