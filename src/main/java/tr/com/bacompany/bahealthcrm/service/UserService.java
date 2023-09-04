package tr.com.bacompany.bahealthcrm.service;

import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto get(Long id) throws ResourceNotFoundException;

    boolean isPresent(Long id);

    UserDto save(UserDto user);
}
