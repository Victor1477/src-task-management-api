package com.task.management.api.service;

import com.task.management.api.dto.TaskDTO;
import com.task.management.api.entity.TaskEntity;
import com.task.management.api.repository.TasksRepository;
import com.task.management.api.utils.DateUtils;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service()
public class TasksService {
    @Resource
    private TasksRepository repository;

    public List<TaskEntity> getAllTasks() {
        System.out.println("Getting all tasks " + DateUtils.getCurrentDateTime());
        List<TaskEntity> resultList = this.repository.findAll();
        resultList.sort((t1, t2) -> -t1.getCreatedDate().compareTo(t2.getCreatedDate()));
        return resultList;
    }

    @Transactional
    public TaskEntity saveTask(TaskDTO taskDto) {
        System.out.println("Adding task code: " + taskDto.getCode() + " " + DateUtils.getCurrentDateTime());
        return this.repository.save(new TaskEntity(taskDto));
    }

    @Transactional
    public TaskEntity updateTask(TaskDTO taskDto) {
        System.out.println("Updating task code: " + taskDto.getCode() + " " + DateUtils.getCurrentDateTime());
        TaskEntity task = this.repository.findById(taskDto.id).get();
        return task.update(taskDto);
    }

    @Transactional
    public TaskEntity deleteTask(Long id) {
        System.out.println("Deleting task id: " + id + " " + DateUtils.getCurrentDateTime());
        TaskEntity task = this.repository.findById(id).get();
        this.repository.delete(task);
        return task;
    }
}