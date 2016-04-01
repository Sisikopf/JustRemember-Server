package com.justremember.repositories;

import com.justremember.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Andrey on 19.03.2016.
 */
public interface TagRepository extends CrudRepository<Tag, Long> {
    @Query("select tag from Tag tag where (:userId)=tag.user.id")
    Iterable<Tag> getTagsByUserId(@Param("userId") long userId);
}
