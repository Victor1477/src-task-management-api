package com.task.management.api.repository;

import com.task.management.api.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
}
