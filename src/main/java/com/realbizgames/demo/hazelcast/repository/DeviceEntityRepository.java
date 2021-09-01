package com.realbizgames.demo.hazelcast.repository;

import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceEntityRepository extends CrudRepository<DeviceEntity, String> {

}
