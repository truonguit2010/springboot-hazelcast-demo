package com.realbizgames.demo.hazelcast.service.user;

import com.realbizgames.demo.hazelcast.consts.ServiceErrorCode;
import com.realbizgames.demo.hazelcast.convertor.UserDTOConvertor;
import com.realbizgames.demo.hazelcast.convertor.UserEntityConvertor;
import com.realbizgames.demo.hazelcast.dto.UserDTO;
import com.realbizgames.demo.hazelcast.entity.UserEntity;
import com.realbizgames.demo.hazelcast.exception.BaseServiceException;
import com.realbizgames.demo.hazelcast.repository.UserEntityRepository;
import com.realbizgames.demo.hazelcast.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.realbizgames.demo.hazelcast.cache.entity.IUserEntityCache;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDTOConvertor userDTOConvertor;
    @Autowired
    private UserEntityConvertor userEntityConvertor;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private IUserEntityCache userEntityCache;
    @Autowired
    private MessageSource messageSource;

    private UserEntity findOldOne(String userId) {
        if (StringUtils.isNullOrEmpty(userId)) {
            throw BaseServiceException.of(ServiceErrorCode.USER_ID_NULL_OR_EMPTY_EXCEPTION, messageSource, "user.exception.id-null-or-empty");
        }
        Optional<UserEntity> optional = userEntityRepository.findById(userId);
        if (optional.isEmpty()) {
            throw BaseServiceException.of(ServiceErrorCode.USER_NOT_FOUND_EXCEPTION, messageSource, "user.exception.not-found-by-id", new Object[]{userId});
        }
        return optional.get();
    }

    @Override
    public UserDTO create(UserDTO dto) {
        UserEntity userEntity = userEntityConvertor.convert(dto);
        UserEntity createdOne = userEntityRepository.save(userEntity);
        return userDTOConvertor.convert(createdOne);
    }

    @Override
    public void update(UserDTO dto) {
        UserEntity oldOne = findOldOne(dto.getId());
        UserEntity newOne = userEntityConvertor.convert(dto);
        newOne.setCreatedAt(oldOne.getCreatedAt());
        userEntityRepository.save(newOne);

        userEntityCache.evict(dto.getId());
    }

    @Override
    public void delete(String userId) {
        UserEntity oldOne = findOldOne(userId);
        userEntityRepository.deleteById(userId);

        userEntityCache.evict(userId);
    }

    @Override
    public UserDTO get(String id) {
        UserEntity oldOne = findOldOne(id);
        return userDTOConvertor.convert(oldOne);
    }
}
