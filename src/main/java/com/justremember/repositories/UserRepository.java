package com.justremember.repositories;

import com.justremember.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by dimko_000 on 19.03.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
