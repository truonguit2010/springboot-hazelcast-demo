package com.realbizgames.demo.hazelcast.convertor;

import com.realbizgames.demo.hazelcast.dto.DeviceDTO;
import com.realbizgames.demo.hazelcast.dto.UserDTO;
import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceEntityConvertor implements IConvertor<DeviceEntity, DeviceDTO> {

    @Override
    public DeviceEntity convert(DeviceDTO dto) {
        DeviceEntity entity = new DeviceEntity();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setDeviceId(dto.getDeviceId());
        entity.setOs(dto.getOs());

        return entity;
    }

    @Override
    public List<DeviceEntity> convert(Iterable<DeviceDTO> dtoList) {
        List<DeviceEntity> entities = new ArrayList<>();
        for (var item : dtoList) {
            entities.add(convert(item));
        }
        return entities;
    }
}
