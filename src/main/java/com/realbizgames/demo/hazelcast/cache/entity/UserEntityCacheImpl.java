package com.realbizgames.demo.hazelcast.cache.entity;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.realbizgames.demo.hazelcast.cache.MapName;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserEntityCacheImpl implements IUserEntityCache {

    private HazelcastInstance hazelcastInstance;
    private IMap<String, UserEntity> cache;

    public UserEntityCacheImpl(
            @Qualifier("defineHazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
        this.cache = hazelcastInstance.getMap(MapName.USER_ENTITY.getMapName());
    }

    @Override
    public void cache(UserEntity entity) {
        this.cache.set(entity.getId(), entity);
    }

    @Override
    public UserEntity get(String id) {
        return this.cache.get(id);
    }

    @Override
    public void evict(String id) {
        this.cache.evict(id);
    }
}
