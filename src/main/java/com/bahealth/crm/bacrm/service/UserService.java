package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto find(Long id);

    UserDto save(UserDto user);
}
