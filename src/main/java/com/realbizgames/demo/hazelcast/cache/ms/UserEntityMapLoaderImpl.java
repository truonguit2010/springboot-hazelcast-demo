package com.realbizgames.demo.hazelcast.cache.ms;

import com.hazelcast.map.MapLoader;
import com.realbizgames.demo.hazelcast.config.ServiceJsonMapper;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import com.realbizgames.demo.hazelcast.repository.UserEntityRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class UserEntityMapLoaderImpl implements MapLoader<String, UserEntity> {

    @Autowired
    private ServiceJsonMapper serviceJsonMapper;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @SneakyThrows
    @Override
    public UserEntity load(String s) {
        Optional<UserEntity> optional = userEntityRepository.findById(s);
        if (optional.isEmpty()) {
            log.info("load null");
            return null;
        } else {
            UserEntity userEntity = optional.get();
            log.info("load {}", serviceJsonMapper.getMapper().writeValueAsString(userEntity));
            return userEntity;
        }
    }

    @SneakyThrows
    @Override
    public Map<String, UserEntity> loadAll(Collection<String> collection) {
        Iterable<UserEntity> entities = userEntityRepository.findAllById(collection);

        Map<String, UserEntity> map = new HashMap<>();
        for (var key : collection) {
            map.put(key, null);
        }
        for (var item : entities) {
            map.put(item.getId(), item);
        }
        log.info("loadAll {}", serviceJsonMapper.getMapper().writeValueAsString(map));
        return map;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        log.info("loadAllKeys");
        return null;
    }
}
