package com.justremember.controllers;

import com.justremember.entities.Note;
import com.justremember.services.api.NoteService;
import com.justremember.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dimko_000 on 01.04.2016.
 */
@RestController
public class NoteController {
    @Autowired
    NoteService noteService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/users/{userId}/notes", method = RequestMethod.GET)
    public Iterable<Note> getAllUserNotes(@PathVariable long userId) {
        return noteService.getNotesByUserId(userId);
    }

    @RequestMapping(value = "/users/{userId}/notes/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable long userId, @PathVariable long id) {
        return noteService.getById(id);
    }

    @RequestMapping(value = "/users/{userId}/notes/", method = RequestMethod.POST)
    public ResponseEntity<?> addNote(@PathVariable long userId, @RequestBody Note note) {
        note.setUser(userService.getById(userId));
        noteService.save(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/users/{userId}/notes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateNote(@PathVariable long userId, @PathVariable long id, @RequestBody Note note) {
        note.setId(id);
        noteService.save(note);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/users/{userId}/notes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNote(@PathVariable long userId, @PathVariable long id) {
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
