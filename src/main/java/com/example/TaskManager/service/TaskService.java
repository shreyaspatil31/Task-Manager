package com.example.TaskManager.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TaskManager.entities.TaskEntity;
import com.example.TaskManager.repositories.NoteRepository;
import com.example.TaskManager.repositories.TaskRepository;
import com.example.TaskManager.entities.NoteEntity;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, NoteRepository noteRepository) {
        this.taskRepository = taskRepository;
        this.noteRepository = noteRepository;
    }

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity task = new TaskEntity();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(Date.valueOf(deadline));
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }

    public TaskEntity getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) {
        TaskEntity task = getTaskById(id);
        if (task == null) {
            return null;
        }
        if (description != null) {
            task.setDescription(description);
        }
        if (deadline != null) {
            task.setDeadline(Date.valueOf(deadline));
        }
        if (completed != null) {
            task.setCompleted(completed);
        }
        return taskRepository.save(task);
    }

    public boolean deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }

    public NoteEntity addNoteToTask(int taskId, String description, boolean completed) {
        TaskEntity task = getTaskById(taskId);
        if (task == null) {
            return null;
        }
        NoteEntity note = new NoteEntity();
        note.setDescription(description);
        note.setCompleted(completed);
        task.addNote(note);
        taskRepository.save(task);
        return note;
    }

    public List<NoteEntity> getNotesForTask(int taskId) {
        TaskEntity task = getTaskById(taskId);
        return (task != null) ? task.getNotes() : null;
    }
}
