package com.bahealth.crm.bacrm.data.dto;

import com.bahealth.crm.bacrm.data.dto.user.RoleDto;
import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.entity.treatment.Treatment;
import com.bahealth.crm.bacrm.data.entity.user.Role;
import com.bahealth.crm.bacrm.data.entity.user.User;
import com.bahealth.crm.bacrm.data.entity.work.WorkStatus;
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
