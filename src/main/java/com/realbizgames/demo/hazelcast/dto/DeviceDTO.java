package com.realbizgames.demo.hazelcast.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeviceDTO {
    private String id;
    private String userId;
    private String deviceId;
    private String os;

    private String createdAt;
    private String updatedAt;
}
