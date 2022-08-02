package com.stage.proxym.user.mapper;

import com.stage.proxym.dto.UserDto;
import com.stage.proxym.user.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    ModelMapper modelMapper = new ModelMapper();

    public UserDto mapToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
    public User mapToEntity(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }
    public List<UserDto> mapToDtoListUser (List<User> users){
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}

