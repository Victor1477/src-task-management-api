package com.task.management.api.controller;

import com.task.management.api.entity.AttachmentEntity;
import com.task.management.api.service.AttachmentService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/tasks/attachments")
public class AttachmentController {

    @Resource
    private AttachmentService service;

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam MultipartFile file, @RequestHeader("taskId") Long taskId) throws IOException {
        this.service.upload(file, taskId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Long id, @RequestParam(value = "w", required = false) String w) throws IOException {
        AttachmentEntity attachment = this.service.download(id);
        if (w != null && w.equals("download")) {
            return ResponseEntity.ok().header("Content-Disposition", "attachment").contentType(MediaType.valueOf(attachment.contentType)).body(attachment.fileData);
        } else {
            return ResponseEntity.ok().contentType(MediaType.valueOf(attachment.contentType)).body(attachment.fileData);
        }
    }

    @GetMapping
    public ResponseEntity<List<AttachmentEntity>> getAllByTaskId(@RequestHeader("taskId") Long id) {
        return ResponseEntity.ok().body(this.service.getAllByTaskId(id));
    }

    @DeleteMapping
    public ResponseEntity deleteAttachment(@RequestHeader Long id) {
        try {
            this.service.deleteAttachment(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
