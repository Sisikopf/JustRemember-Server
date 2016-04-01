package com.justremember.repositories;

import com.justremember.entities.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Andrey on 19.03.2016.
 */
public interface NoteRepository extends CrudRepository<Note, Long> {
    @Query("select note from Note note where (:userId)=note.user.id")
    Iterable<Note> getNotesByUserId(@Param("userId") long userId);
}
