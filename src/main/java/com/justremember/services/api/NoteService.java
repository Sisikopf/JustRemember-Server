package com.justremember.services.api;

import com.justremember.entities.Note;

/**
 * Created by dimko_000 on 01.04.2016.
 */
public interface NoteService extends CommonService<Note> {
    Iterable<Note> getNotesByUserId(long userId);
}
