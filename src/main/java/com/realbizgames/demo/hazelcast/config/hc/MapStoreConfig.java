package com.realbizgames.demo.hazelcast.config.hc;

import com.hazelcast.config.MapConfig;
import com.realbizgames.demo.hazelcast.config.hc.mapstore.DeviceEntityMapStoreConfig;
import com.realbizgames.demo.hazelcast.config.hc.mapstore.UserEntityMapStoreConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapStoreConfig {

    @Autowired
    private UserEntityMapStoreConfig userEntityMapStoreConfig;
    @Autowired
    private DeviceEntityMapStoreConfig deviceEntityMapStoreConfig;

    @Bean
    public List<MapConfig> getMapConfigs() {
        List<MapConfig> mapConfigList = new ArrayList<>();

        mapConfigList.add(userEntityMapStoreConfig.config());
        mapConfigList.add(deviceEntityMapStoreConfig.config());

        return mapConfigList;
    }
}
