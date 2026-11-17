package com.security.notesApp.services.impl;

import com.security.notesApp.models.Note;
import com.security.notesApp.repositories.Repository;
import com.security.notesApp.service.NoteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private Repository noteRepo;

    @Override
    public Note createNoteForUser(String username, String content){
        Note note =new Note();
        note.setContent(content);
        note.setOwnerUsername(username);

        return noteRepo.save(note);
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepo.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        note.setContent(content);

        return noteRepo.save(note);
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        noteRepo.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        return noteRepo.findByOwnerUsername(username);
    }
}
