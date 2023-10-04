package com.dpostnov.notebook.tasks.controller;

import com.dpostnov.notebook.tasks.dao.TaskRepository;
import com.dpostnov.notebook.tasks.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dmitriy Postnov
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping("/findAll")
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
