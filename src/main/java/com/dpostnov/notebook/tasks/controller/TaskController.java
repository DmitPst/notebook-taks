package com.dpostnov.notebook.tasks.controller;

import com.dpostnov.notebook.tasks.model.Task;
import com.dpostnov.notebook.tasks.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dmitriy Postnov
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = taskService.findAll();
        if (tasks.size() == 0)
            return new ResponseEntity<>(tasks, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Task> findById(@RequestParam String id) {
        return taskService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
