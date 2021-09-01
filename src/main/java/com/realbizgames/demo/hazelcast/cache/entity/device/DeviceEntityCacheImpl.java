package com.realbizgames.demo.hazelcast.cache.entity.device;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.realbizgames.demo.hazelcast.cache.MapName;
import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DeviceEntityCacheImpl implements IDeviceEntityCache {

    private HazelcastInstance hazelcastInstance;
    private IMap<String, DeviceEntity> cache;

    public DeviceEntityCacheImpl(
            @Qualifier("defineHazelcastInstance") HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
        this.cache = hazelcastInstance.getMap(MapName.DEVICE_ENTITY.getMapName());
    }

    @Override
    public void cache(DeviceEntity entity) {
        this.cache.set(entity.getId(), entity);
    }

    @Override
    public DeviceEntity get(String id) {
        return this.cache.get(id);
    }
}
