package com.realbizgames.demo.hazelcast.config.hc;

import com.hazelcast.config.SerializerConfig;
import com.hazelcast.nio.serialization.ByteArraySerializer;
import com.realbizgames.demo.hazelcast.config.ServiceJsonMapper;
import com.realbizgames.demo.hazelcast.config.hc.serializer.HCJsonByteArraySerializer;
import com.realbizgames.demo.hazelcast.config.hc.serializer.SerializerId;
import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HazelcastSerializerConfig {

    @Autowired
    private ServiceJsonMapper serviceJsonMapper;

    @Bean
    public List<SerializerConfig> getSerializerConfigs() {
        List<SerializerConfig> serializerConfigList = new ArrayList<>();

        serializerConfigList.add(forUserEntity());
        serializerConfigList.add(forDeviceEntity());

        return serializerConfigList;
    }

    private SerializerConfig forUserEntity() {
        ByteArraySerializer<UserEntity> userEntitySerializerImpl = new HCJsonByteArraySerializer(SerializerId.USER_ENTITY.getId(), UserEntity.class, serviceJsonMapper.getMapper());
        SerializerConfig userSerializerConfig = new SerializerConfig().setImplementation(userEntitySerializerImpl).setTypeClass(UserEntity.class);
        return userSerializerConfig;
    }

    private SerializerConfig forDeviceEntity() {
        ByteArraySerializer<DeviceEntity> userEntitySerializerImpl = new HCJsonByteArraySerializer(SerializerId.DEVICE_ENTITY.getId(), DeviceEntity.class, serviceJsonMapper.getMapper());
        SerializerConfig deviceSerializerConfig = new SerializerConfig().setImplementation(userEntitySerializerImpl).setTypeClass(DeviceEntity.class);
        return deviceSerializerConfig;
    }
}
