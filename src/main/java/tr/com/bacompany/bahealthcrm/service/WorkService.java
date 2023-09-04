package tr.com.bacompany.bahealthcrm.service;

import tr.com.bacompany.bahealthcrm.data.dto.WorkDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;

import java.util.List;

public interface WorkService {
    void assignWorkToUsers(Long workId, List<UserDto> users) throws ResourceNotFoundException;

    WorkDto get(Long id) throws ResourceNotFoundException;
}
