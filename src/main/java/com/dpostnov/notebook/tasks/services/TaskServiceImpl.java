package com.dpostnov.notebook.tasks.services;

import com.dpostnov.notebook.tasks.dao.TaskRepository;
import com.dpostnov.notebook.tasks.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Dmitriy Postnov
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean delete(String id) {
        Optional<Task> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            taskRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
