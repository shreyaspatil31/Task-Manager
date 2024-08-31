package com.example.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.entities.TaskEntity;


public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}
