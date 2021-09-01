package com.realbizgames.demo.hazelcast.repository;

import com.realbizgames.demo.hazelcast.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, String> {

}
