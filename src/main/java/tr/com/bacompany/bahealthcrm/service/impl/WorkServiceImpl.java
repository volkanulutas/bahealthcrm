package tr.com.bacompany.bahealthcrm.service.impl;

import tr.com.bacompany.bahealthcrm.converter.WorkConverter;
import tr.com.bacompany.bahealthcrm.data.dto.WorkDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.RoleDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.entity.user.User;
import tr.com.bacompany.bahealthcrm.data.entity.work.Work;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;
import tr.com.bacompany.bahealthcrm.data.model.NotificationModel;
import tr.com.bacompany.bahealthcrm.repository.WorkRepository;
import tr.com.bacompany.bahealthcrm.service.NotificationService;
import tr.com.bacompany.bahealthcrm.service.UserService;
import tr.com.bacompany.bahealthcrm.service.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service(value = "workService")
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;

    private final UserService userService;

    private final NotificationService notificationService;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository, UserService userService, NotificationService notificationService) {
        this.workRepository = workRepository;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @Override
    public WorkDto get(Long id) throws ResourceNotFoundException {
        Optional<Work> optWork = workRepository.findById(id);
        if (optWork.isPresent()) {
            return WorkConverter.toDto(optWork.get());
        }
        throw new ResourceNotFoundException("Work is not found with the related 'id'", "Work");
    }

    @Override
    public void assignWorkToUsers(Long workId, List<UserDto> users) throws ResourceNotFoundException {
        WorkDto workDto = get(workId);
        // user check
        for (UserDto user : users) {
            if (!userService.isPresent(user.getId())) {
                throw new ResourceNotFoundException("User", "User is not found for assigning work(s). User id: " + user.getId());
            }
        }
        workDto.setAssignedUsers(new HashSet<>(users));
        Work work = WorkConverter.toEntity(workDto);
        workRepository.save(work);
        // notify user(s) which has track of this work.
        Set<RoleDto> notificationRoles = workDto.getNotificationRoles();
        notificationRoles.stream().map(role -> new NotificationModel(workDto.getTreatment(), role,
                        "İş Atanması Bildirimi (Rolünüz bunu görme hakkına sahip). Detaylar: " + workDto.toString(), System.currentTimeMillis()))
                .forEach(notificationService::notify);
        // notify assigned user
        Set<User> assignedUsers = work.getAssignedUsers();
        assignedUsers.stream().map(user -> new NotificationModel(workDto.getTreatment(), user, "Size iş atandı. Detaylar: " + workDto.toString(),
                System.currentTimeMillis())).forEach(notificationService::notify);
    }
}
