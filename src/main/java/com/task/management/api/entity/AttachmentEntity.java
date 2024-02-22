package com.task.management.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "attachments")
@Setter
@Getter
@NoArgsConstructor
public class AttachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String fileName;

    @Column
    @JsonIgnore
    public String contentType;

    @Lob
    @Column
    @JsonIgnore
    public byte[] fileData;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "task_id")
    public TaskEntity task;

    public AttachmentEntity(String fileName, String contentType, byte[] fileData, Long taskId) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileData = fileData;
        if (this.task == null)
            this.task = new TaskEntity();
        this.task.id = taskId;
    }
}