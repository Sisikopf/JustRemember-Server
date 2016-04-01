package com.justremember.services.impl;

import com.justremember.entities.Note;
import com.justremember.repositories.NoteRepository;
import com.justremember.services.api.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by dimko_000 on 01.04.2016.
 */
@Transactional
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note getById(long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note object) {
        noteRepository.save(object);
    }

    @Override
    public void delete(Note object) {
        noteRepository.delete(object);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.delete(id);
    }

    @Override
    public Iterable<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Iterable<Note> getNotesByUserId(long userId) {
        return noteRepository.getNotesByUserId(userId);
    }
}
