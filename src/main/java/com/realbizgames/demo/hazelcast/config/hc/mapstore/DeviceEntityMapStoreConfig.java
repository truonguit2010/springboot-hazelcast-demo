package com.realbizgames.demo.hazelcast.config.hc.mapstore;

import com.hazelcast.config.*;
import com.realbizgames.demo.hazelcast.cache.MapName;
import com.realbizgames.demo.hazelcast.cache.ms.DeviceEntityMapStoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceEntityMapStoreConfig implements IMapStoreConfig {

    @Autowired
    private DeviceEntityMapStoreImpl deviceEntityMapStore;

    @Override
    public MapConfig config() {
        MapConfig customerMapConfig = new MapConfig(MapName.DEVICE_ENTITY.getMapName());
        customerMapConfig.setTimeToLiveSeconds(3600);
        customerMapConfig.setMaxIdleSeconds(600);
        customerMapConfig.setEvictionConfig(getEvictionConfig());
        customerMapConfig.setMapStoreConfig(getMapStoreConfig());

        return customerMapConfig;
    }

    private EvictionConfig getEvictionConfig() {
        EvictionConfig evictionConfig = new EvictionConfig();
        evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
        evictionConfig.setMaxSizePolicy(MaxSizePolicy.PER_NODE);
        evictionConfig.setSize(10000);

        return evictionConfig;
    }

    private MapStoreConfig getMapStoreConfig() {
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setEnabled(true);
        mapStoreConfig.setImplementation(deviceEntityMapStore);
        mapStoreConfig.setInitialLoadMode(MapStoreConfig.InitialLoadMode.LAZY);

        // Config write behind cache
        mapStoreConfig.setWriteBatchSize(50);
        mapStoreConfig.setWriteDelaySeconds(5);
        mapStoreConfig.setWriteCoalescing(true);

        return mapStoreConfig;
    }
}
