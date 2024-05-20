package com.task.management.api.repository;

import com.task.management.api.entity.AttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<AttachmentEntity, Long> {
    Optional<List<AttachmentEntity>> findAllByTaskId(Long id);
}
