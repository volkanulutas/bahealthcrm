package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.WorkDto;
import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;

import java.util.List;

public interface WorkService {
    void assignWorkToUsers(Long workId, List<UserDto> users) throws ResourceNotFoundException;

    WorkDto get(Long id) throws ResourceNotFoundException;
}
