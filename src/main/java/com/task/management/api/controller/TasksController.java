package com.task.management.api.controller;

import com.task.management.api.dto.TaskDTO;
import com.task.management.api.entity.TaskEntity;
import com.task.management.api.service.TasksService;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Resource
    private TasksService service;

    @Setter
    @Getter
    public class ErrorHandler {
        String message;
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        return ResponseEntity.ok(this.service.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<TaskEntity> saveTask(@RequestBody TaskDTO taskDto) {
        return ResponseEntity.ok(this.service.saveTask(taskDto));
    }

    @PutMapping
    public ResponseEntity updateTask(@RequestBody TaskDTO taskDto) {
        if (taskDto.getId() == 0) {
            ErrorHandler errorHandler = new ErrorHandler();
            errorHandler.setMessage("Update a task requires the Id");
            return ResponseEntity.badRequest().body(errorHandler);
        }
        return ResponseEntity.ok(this.service.updateTask(taskDto));
    }

    @DeleteMapping
    public ResponseEntity deleteTask(@RequestHeader("id") Long id) {
        TaskEntity task = this.service.deleteTask(id);
        return ResponseEntity.ok("Sucessfully deleted: " + task.getCode());
    }
}
