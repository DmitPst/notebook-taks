package com.dpostnov.notebook.tasks.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dmitriy Postnov
 */
@Getter
@Setter
@NoArgsConstructor
@Document("task")
public class Task {
    private String id;
    private String name;
}
