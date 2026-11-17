package com.security.notesApp.controller;

import com.security.notesApp.models.Note;
import com.security.notesApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@AuthenticationPrincipal UserDetails userDetails,@RequestBody String content ){
       String username= userDetails.getUsername();
        System.out.println("user details:"+username);
        return noteService.createNoteForUser(username,content);
    }

    @GetMapping
    public List<Note> getNote(@AuthenticationPrincipal UserDetails userDetails){
        String username=userDetails.getUsername();
        return noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId,@RequestBody String content,@AuthenticationPrincipal UserDetails userDetails)
    {
        String username= userDetails.getUsername();
        return noteService.updateNoteForUser(noteId,content,username);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId,@AuthenticationPrincipal UserDetails userDetails){
        String username= userDetails.getUsername();
        noteService.deleteNoteForUser(noteId,username);
    }




}
