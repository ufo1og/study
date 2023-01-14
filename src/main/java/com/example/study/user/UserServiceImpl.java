package com.example.study.user;

import com.example.study.user.dto.UserCreateDto;
import com.example.study.user.dto.UserDto;
import com.example.study.user.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userCreateDto)));
    }

    @Override
    public UserDto readById(Long id) {
        return userRepository.findById(id).map(UserMapper::toUserDto).get();
    }

    @Override
    public Page<UserDto> readPage(int pageSize, int pageNumber) {
        Sort sortById = Sort.by(Sort.Direction.ASC, "id");
        Pageable page = PageRequest.of(pageNumber, pageSize, sortById);
        return userRepository.findAll(page).map(UserMapper::toUserDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        userRepository.updateUser(userDto);
        return null;
    }
}
