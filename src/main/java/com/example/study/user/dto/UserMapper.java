package com.example.study.user.dto;

import com.example.study.user.model.User;

public class UserMapper {
    public static User toUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setBirthday(userCreateDto.getBirthday());
        return user;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthday(userDto.getBirthday());
        user.setRegistrationDate(userDto.getRegistrationDate());
        return user;
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthday(),
                user.getRegistrationDate());
    }
}
