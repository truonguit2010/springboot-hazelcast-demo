package com.realbizgames.demo.hazelcast.config.hc;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// https://docs.hazelcast.com/imdg/4.1.2/serialization/custom-serialization.html
// Implementing ByteArraySerializer => the best choice to java-java
@Configuration
public class HazelcastConfig {

    @Autowired
    private HazelcastInfo hazelcastInfo;
    @Autowired
    private List<MapConfig> mapConfigList;
    @Autowired
    private List<SerializerConfig> serializerConfigList;

    @Bean
    HazelcastInstance defineHazelcastInstance() {
        Config config = new Config();

        // Map Store
        for (MapConfig mapConfig : mapConfigList) {
            config.addMapConfig(mapConfig);
        }

        // Serialization
        for (SerializerConfig serializerConfig : serializerConfigList) {
            config.getSerializationConfig().addSerializerConfig(serializerConfig);
        }

        // Join config.
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);

        if (hazelcastInfo.isKubernetesEnabled()) {
            config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true)
                    .setProperty("namespace", hazelcastInfo.getNamespace())
                    .setProperty("service-name", hazelcastInfo.getServiceName());
        } else {
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(true);
            config.setClusterName(hazelcastInfo.getClusterName());
        }

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        return hazelcastInstance;
    }
}
