package com.justremember.services.impl;

import com.justremember.entities.User;
import com.justremember.repositories.UserRepository;
import com.justremember.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dimko_000 on 31.03.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User object) {
        userRepository.save(object);
    }

    @Override
    public void deleteById(long id) {
        userRepository.delete(id);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
