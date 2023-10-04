package com.dpostnov.notebook.tasks.dao;

import com.dpostnov.notebook.tasks.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Dmitriy Postnov
 */
public interface TaskRepository extends MongoRepository<Task, String> {
}
