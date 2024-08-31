package com.example.TaskManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.TaskManager.dto.CreateTaskDTO;
import com.example.TaskManager.dto.UpdateTaskDTO;
import com.example.TaskManager.dto.CreateNoteDTO;
import com.example.TaskManager.entities.TaskEntity;
import com.example.TaskManager.entities.NoteEntity;
import com.example.TaskManager.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // REST API Methods

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        List<TaskEntity> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int id) {
        TaskEntity task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) {
        TaskEntity task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(
            @PathVariable int id,
            @RequestBody UpdateTaskDTO body) {
        TaskEntity updatedTask = taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getCompleted());
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        boolean isDeleted = taskService.deleteTask(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/notes")
    public ResponseEntity<NoteEntity> addNoteToTask(
            @PathVariable int id,
            @RequestBody CreateNoteDTO body) {
        NoteEntity note = taskService.addNoteToTask(id, body.getDescription(), body.isCompleted());
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(note);
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<List<NoteEntity>> getNotesForTask(@PathVariable int id) {
        List<NoteEntity> notes = taskService.getNotesForTask(id);
        if (notes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notes);
    }

   
}
