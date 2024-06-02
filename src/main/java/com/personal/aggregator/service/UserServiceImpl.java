package com.personal.aggregator.service;

import com.personal.aggregator.entity.UserEntity;
import com.personal.aggregator.model.UserDto;
import com.personal.aggregator.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl {

    @Autowired
    private UserJpaRepository userJpaRepository;
    public void save(UserDto userDto){
        if(!userExists(userDto)) {
            log.info("User Do not exist {}, {}", userDto.getEmail(), userDto.getName());
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userDto.getName());
            userEntity.setEmail(userDto.getEmail());
            userJpaRepository.save(userEntity);
        }
    }

    private boolean userExists(UserDto userDto) {
        UserEntity entity = userJpaRepository.findByName(userDto.getName());
        return entity != null;
    }

}
