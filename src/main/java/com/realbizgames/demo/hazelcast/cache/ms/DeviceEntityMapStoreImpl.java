package com.realbizgames.demo.hazelcast.cache.ms;

import com.hazelcast.map.MapStore;
import com.realbizgames.demo.hazelcast.config.ServiceJsonMapper;
import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import com.realbizgames.demo.hazelcast.repository.DeviceEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
public class DeviceEntityMapStoreImpl implements MapStore<String, DeviceEntity> {

    @Autowired
    private ServiceJsonMapper serviceJsonMapper;
    @Autowired
    private DeviceEntityRepository deviceEntityRepository;

    @Override
    public DeviceEntity load(String s) {
        return null;
    }

    @Override
    public Map<String, DeviceEntity> loadAll(Collection<String> collection) {
        return null;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        return null;
    }

    @Override
    public void store(String s, DeviceEntity deviceEntity) {

    }

    @Override
    public void storeAll(Map<String, DeviceEntity> map) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void deleteAll(Collection<String> collection) {

    }
}
