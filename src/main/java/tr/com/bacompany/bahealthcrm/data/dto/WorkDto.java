package tr.com.bacompany.bahealthcrm.data.dto;

import tr.com.bacompany.bahealthcrm.data.dto.user.RoleDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.entity.work.WorkStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class WorkDto implements Serializable {
    private Long id;

    private String name;

    private String definition;

    private WorkStatus status;

    private Long planningDate;

    private Long startDate;

    private Long endDate;

    private Set<RoleDto> notificationRoles = new HashSet<>();

    private TreatmentDto treatment;

    private Set<UserDto> assignedUsers = new HashSet<>();
}
