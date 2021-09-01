package com.realbizgames.demo.hazelcast.convertor;

import com.realbizgames.demo.hazelcast.dto.DeviceDTO;
import com.realbizgames.demo.hazelcast.entity.DeviceEntity;
import com.realbizgames.demo.hazelcast.utils.DateTimeConvertor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceDTOConvertor implements IConvertor<DeviceDTO, DeviceEntity> {

    @Override
    public DeviceDTO convert(DeviceEntity entity) {
        DeviceDTO dto = new DeviceDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setDeviceId(entity.getDeviceId());
        dto.setOs(entity.getOs());

        dto.setCreatedAt(DateTimeConvertor.from(entity.getCreatedAt()));
        dto.setUpdatedAt(DateTimeConvertor.from(entity.getUpdatedAt()));
        return dto;
    }

    @Override
    public List<DeviceDTO> convert(Iterable<DeviceEntity> entities) {
        List<DeviceDTO> dtoList = new ArrayList<>();
        for (var item : entities) {
            dtoList.add(convert(item));
        }
        return dtoList;
    }
}
