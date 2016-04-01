package com.justremember.controllers;

import com.justremember.entities.Tag;
import com.justremember.services.api.TagService;
import com.justremember.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dimko_000 on 01.04.2016.
 */
@RestController
public class TagController {
    @Autowired
    TagService tagService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/{userId}/tags", method = RequestMethod.GET)
    public Iterable<Tag> getAllUserTags(@PathVariable long userId) {
        return tagService.getTagsByUserId(userId);
    }

    @RequestMapping(value = "/users/{userId}/tags/{id}", method = RequestMethod.GET)
    public Tag getTagById(@PathVariable long userId, @PathVariable long id) {
        return tagService.getById(id);
    }
    @RequestMapping(value = "/users/{userId}/tags/", method = RequestMethod.POST)
    public ResponseEntity<?> addTag(@PathVariable long userId, @RequestBody Tag tag) {
        tag.setUser(userService.getById(userId));
        tagService.save(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/users/{userId}/tags/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTag(@PathVariable long userId, @PathVariable long id, @RequestBody Tag tag) {
        tag.setId(id);
        tagService.save(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/users/{userId}/tags/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTag(@PathVariable long userId, @PathVariable long id) {
        tagService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
