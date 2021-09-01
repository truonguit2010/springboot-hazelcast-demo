package com.realbizgames.demo.hazelcast.cache.entity;

import com.realbizgames.demo.hazelcast.entity.UserEntity;

public interface IUserEntityCache {
    void cache(UserEntity entity);

    UserEntity get(String id);

    void evict(String id);
}
