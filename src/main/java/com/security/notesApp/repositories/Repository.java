package com.security.notesApp.repositories;


import com.security.notesApp.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Note,Long> {
   List<Note> findByOwnerUsername(String OwnerUsername);
}
