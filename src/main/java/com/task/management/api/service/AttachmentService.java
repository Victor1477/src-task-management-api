package com.task.management.api.service;

import com.task.management.api.entity.AttachmentEntity;
import com.task.management.api.repository.AttachmentRepository;
import com.task.management.api.utils.DateUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AttachmentService {

    @Resource
    private AttachmentRepository repository;

    public void upload(MultipartFile file, Long taskId) throws IOException {
        String fileName = file.getOriginalFilename().split("\\.")[0];
        System.out.println(DateUtils.getCurrentDateTime() + " Uploading Attachment: " + fileName);
        this.repository.save(new AttachmentEntity(fileName, file.getContentType(), file.getBytes(), taskId));
    }

    public AttachmentEntity download(Long id) {
        System.out.println(DateUtils.getCurrentDateTime() + " Downloading task with id: " + id);
        return this.repository.findById(id).get();
    }

    public List<AttachmentEntity> getAllByTaskId(Long id) {
        System.out.println(DateUtils.getCurrentDateTime() + " Getting all attachments for task with id: " + id);
        return this.repository.findAllByTaskId(id).get();
    }

    public void deleteAttachment(Long id) {
        System.out.println(DateUtils.getCurrentDateTime() + " Deleting Attachment with id: " + id);
        this.repository.deleteById(id);
    }
}
