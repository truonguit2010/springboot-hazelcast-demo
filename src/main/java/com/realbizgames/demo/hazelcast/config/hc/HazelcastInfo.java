package com.realbizgames.demo.hazelcast.config.hc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class HazelcastInfo {
    @Value("${hazelcast.service.name}")
    String serviceName;

    @Value("${hazelcast.service.namespace}")
    String namespace;

    @Value("${hazelcast.kubernetes.enable}")
    boolean kubernetesEnabled;

    @Value("${hazelcast.service.cluster.name}")
    String clusterName;
    @Value("${hazelcast.write.behind.cache.default.batch.size}")
    Integer defaultBatchSize;
    @Value("${hazelcast.write.behind.cache.default.delay.seconds}")
    Integer defaultDelaySeconds;
}
