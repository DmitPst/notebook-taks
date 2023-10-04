package com.dpostnov.notebook.tasks.services;

import com.dpostnov.notebook.tasks.model.Task;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitriy Postnov
 */
public interface TaskService {
    List<Task> findAll();

    Optional<Task> findById(String id);

    Task update(Task task);

    boolean delete(String id);

    Task save(Task task);
}
