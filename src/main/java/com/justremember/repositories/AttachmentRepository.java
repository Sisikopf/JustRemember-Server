package com.justremember.repositories;

import com.justremember.entities.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Andrey on 19.03.2016.
 */
@RepositoryRestResource(collectionResourceRel = "attachment", path = "attachment")
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}
