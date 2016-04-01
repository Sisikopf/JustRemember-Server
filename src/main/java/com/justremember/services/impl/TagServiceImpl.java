package com.justremember.services.impl;

import com.justremember.entities.Tag;
import com.justremember.repositories.TagRepository;
import com.justremember.services.api.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by dimko_000 on 01.04.2016.
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag getById(long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public void save(Tag object) {
        tagRepository.save(object);
    }

    @Override
    public void delete(Tag object) {
        tagRepository.delete(object);
    }

    @Override
    public void deleteById(long id) {
        tagRepository.delete(id);
    }

    @Override
    public Iterable<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Iterable<Tag> getTagsByUserId(long userId) {
        return tagRepository.getTagsByUserId(userId);
    }
}
