package com.example.study.user;

import com.example.study.user.dto.UserCreateDto;
import com.example.study.user.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserService {
    UserDto create(UserCreateDto userCreateDto);

    UserDto readById(Long id);

    Page<UserDto> readPage(int pageSize, int pageNumber);

    UserDto update(UserDto userDto);
}
