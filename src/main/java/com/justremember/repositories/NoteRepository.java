package com.justremember.repositories;

import com.justremember.entities.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Andrey on 19.03.2016.
 */
@RepositoryRestResource(collectionResourceRel = "notes", path = "notes")
public interface NoteRepository extends CrudRepository<Note, Long> {
}
