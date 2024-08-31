package com.example.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManager.entities.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {

}
