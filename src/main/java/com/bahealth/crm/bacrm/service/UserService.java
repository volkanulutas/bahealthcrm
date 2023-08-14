package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto get(Long id) throws ResourceNotFoundException;

    boolean isPresent(Long id);

    UserDto save(UserDto user);
}
