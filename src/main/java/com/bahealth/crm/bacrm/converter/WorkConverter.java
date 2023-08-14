package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.converter.user.RoleConverter;
import com.bahealth.crm.bacrm.converter.user.UserConverter;
import com.bahealth.crm.bacrm.data.dto.WorkDto;
import com.bahealth.crm.bacrm.data.dto.user.RoleDto;
import com.bahealth.crm.bacrm.data.dto.user.UserDto;
import com.bahealth.crm.bacrm.data.entity.user.Role;
import com.bahealth.crm.bacrm.data.entity.user.User;
import com.bahealth.crm.bacrm.data.entity.work.Work;

import java.util.Set;
import java.util.stream.Collectors;

public class WorkConverter {
    public static Work toEntity(WorkDto source) {
        Work target = new Work();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDefinition(source.getDefinition());
        target.setStatus(source.getStatus());
        target.setPlanningDate(source.getPlanningDate());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        Set<Role> roles = source.getNotificationRoles().stream().map(RoleConverter::toEntity).collect(Collectors.toSet());
        target.setNotificationRoles(roles);
        Set<User> users = source.getAssignedUsers().stream().map(UserConverter::toEntity).collect(Collectors.toSet());
        target.setAssignedUsers(users);
        return target;
    }

    public static WorkDto toDto(Work source) {
        WorkDto target = new WorkDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDefinition(source.getDefinition());
        target.setStatus(source.getStatus());
        target.setPlanningDate(source.getPlanningDate());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        Set<RoleDto> roles = source.getNotificationRoles().stream().map(RoleConverter::toDto).collect(Collectors.toSet());
        target.setNotificationRoles(roles);
        Set<UserDto> users = source.getAssignedUsers().stream().map(UserConverter::toDto).collect(Collectors.toSet());
        target.setAssignedUsers(users);
        return target;
    }
}
