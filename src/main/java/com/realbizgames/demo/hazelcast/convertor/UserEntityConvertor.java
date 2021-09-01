package com.realbizgames.demo.hazelcast.convertor;

import com.realbizgames.demo.hazelcast.dto.UserDTO;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEntityConvertor implements IConvertor<UserEntity, UserDTO> {

    @Override
    public UserEntity convert(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());

        return entity;
    }

    @Override
    public List<UserEntity> convert(Iterable<UserDTO> dtoList) {
        List<UserEntity> entities = new ArrayList<>();
        for (var item : dtoList) {
            entities.add(convert(item));
        }
        return entities;
    }
}
