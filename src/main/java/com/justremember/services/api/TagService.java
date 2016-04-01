package com.justremember.services.api;

import com.justremember.entities.Tag;

/**
 * Created by dimko_000 on 01.04.2016.
 */
public interface TagService extends CommonService<Tag> {
    Iterable<Tag> getTagsByUserId(long userId);
}
