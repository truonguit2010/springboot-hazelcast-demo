package com.realbizgames.demo.hazelcast.service.user;

import com.realbizgames.demo.hazelcast.dto.UserDTO;

public interface IUserService {
    UserDTO create(UserDTO dto);
    void update(UserDTO dto);
    void delete(String id);
    UserDTO get(String id);
}
