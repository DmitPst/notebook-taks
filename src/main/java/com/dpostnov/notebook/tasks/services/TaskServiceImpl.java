package com.dpostnov.notebook.tasks.services;

import com.dpostnov.notebook.tasks.dao.TaskRepository;
import com.dpostnov.notebook.tasks.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        log.info("find all");
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(String id) {
        log.info("find by id = {}", id);
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        log.info("update task with id = {}", task.getId());
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        log.info("delete entity, id: {}", id);
        Optional<Task> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            taskRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Task save(Task task) {
        log.info("save entity, task:" + task);
        return taskRepository.save(task);
    }
}
