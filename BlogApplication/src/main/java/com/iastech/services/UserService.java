package com.iastech.services;

import java.util.List;

import com.iastech.payloads.UserDto;

public interface UserService {
UserDto createUser(UserDto userDto);
UserDto updateUser(UserDto userDtor,Integer userId);
UserDto getUserById(Integer userId);
List<UserDto> getAllUsers();
void deleteUser(Integer userId);
}
