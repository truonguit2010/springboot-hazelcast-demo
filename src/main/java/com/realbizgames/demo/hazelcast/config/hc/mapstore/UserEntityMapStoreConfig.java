package com.realbizgames.demo.hazelcast.config.hc.mapstore;

import com.hazelcast.config.*;
import com.realbizgames.demo.hazelcast.cache.MapName;
import com.realbizgames.demo.hazelcast.cache.ms.UserEntityMapLoaderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapStoreConfig implements IMapStoreConfig {

    @Autowired
    private UserEntityMapLoaderImpl userEntityMapLoader;

    @Override
    public MapConfig config() {
        MapConfig customerMapConfig = new MapConfig(MapName.USER_ENTITY.getMapName());
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
        mapStoreConfig.setImplementation(userEntityMapLoader);
        mapStoreConfig.setInitialLoadMode(MapStoreConfig.InitialLoadMode.LAZY);

        return mapStoreConfig;
    }
}
