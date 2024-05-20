package com.task.management.api.service;

import com.task.management.api.dto.TaskDTO;
import com.task.management.api.entity.TaskEntity;
import com.task.management.api.repository.TasksRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class TasksService {
    @Resource
    private TasksRepository repository;

    public List<TaskEntity> getAllTasks() {
        List<TaskEntity> resultList = this.repository.findAll();
        resultList.sort((t1, t2) -> -t1.getCreatedDate().compareTo(t2.getCreatedDate()));
        return resultList;
    }

    @Transactional
    public TaskEntity saveTask(TaskDTO taskDto) {
        return this.repository.save(new TaskEntity(taskDto));
    }

    @Transactional
    public TaskEntity updateTask(TaskDTO taskDto) {
        TaskEntity task = this.repository.findById(taskDto.id).get();
        return task.update(taskDto);
    }

    @Transactional
    public TaskEntity deleteTask(Long id) {
        TaskEntity task = this.repository.findById(id).get();
        this.repository.delete(task);
        return task;
    }
}