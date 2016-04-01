package com.justremember.services.api;

import java.util.List;

/**
 * Created by dimko_000 on 31.03.2016.
 */
public interface CommonService<T> {
    T getById(long id);
    void save(T object);
    void delete(T object);
    void deleteById(long id);
    Iterable<T> getAll();
}
