package com.task.management.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.management.api.dto.TaskDTO;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "tasks")
@Setter
@Getter
public class TaskEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String code;
    @Column
    public String description;
    @Column
    public LocalDateTime createdDate;
    @Column
    public String notes;
    @Column
    public boolean isActive;
    @Column
    public String featureFlagName;
    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    public List<AttachmentEntity> attachments;

    public TaskEntity() {
    }

    public TaskEntity(TaskDTO taskDto) {
        this.setCode(taskDto.getCode());
        this.setDescription(taskDto.getDescription());
        this.setNotes(taskDto.getNotes());
        this.setFeatureFlagName(taskDto.getFeatureFlagName());
        this.setCreatedDate(LocalDateTime.now());
        this.setIsActive(taskDto.getIsActive());
    }

    public TaskEntity update(TaskDTO taskDto) {
        this.setCode(taskDto.getCode());
        this.setDescription(taskDto.getDescription());
        this.setNotes(taskDto.getNotes());
        this.setFeatureFlagName(taskDto.getFeatureFlagName());
        this.setIsActive(taskDto.getIsActive());

        return this;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
