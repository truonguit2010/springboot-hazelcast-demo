package com.realbizgames.demo.hazelcast.cache.entity.device;

import com.realbizgames.demo.hazelcast.entity.DeviceEntity;

public interface IDeviceEntityCache {
    void cache(DeviceEntity entity);

    DeviceEntity get(String id);
}
