package com.practice.service;

import com.practice.model.Todo;
import com.practice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService{
    @Autowired
    TodoRepository todoRepository;

    @Override
    public Page<Todo> listTodos(int page) {
        Sort sort = Sort.by("targetDate").ascending();
        return todoRepository.findAll(PageRequest.of(page,3,sort));
    }

}
