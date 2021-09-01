package com.realbizgames.demo.hazelcast.convertor;

import com.realbizgames.demo.hazelcast.dto.UserDTO;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import com.realbizgames.demo.hazelcast.utils.DateTimeConvertor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOConvertor implements IConvertor<UserDTO, UserEntity> {

    @Override
    public UserDTO convert(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setMobile(entity.getMobile());

        dto.setCreatedAt(DateTimeConvertor.from(entity.getCreatedAt()));
        dto.setUpdatedAt(DateTimeConvertor.from(entity.getUpdatedAt()));
        return dto;
    }

    @Override
    public List<UserDTO> convert(Iterable<UserEntity> entities) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (var item : entities) {
            dtoList.add(convert(item));
        }
        return dtoList;
    }
}
