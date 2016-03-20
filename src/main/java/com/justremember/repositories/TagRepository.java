package com.justremember.repositories;

import com.justremember.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Andrey on 19.03.2016.
 */
@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface TagRepository extends CrudRepository<Tag, Long> {
}
