package com.bahealth.crm.bacrm.converter.user;

import com.bahealth.crm.bacrm.data.dto.user.RoleDto;
import com.bahealth.crm.bacrm.data.entity.user.Role;

public class RoleConverter {
    public static Role toEntity(RoleDto source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setCreationDate(source.getCreationDate());
        return target;
    }

    public static RoleDto toDto(Role source) {
        RoleDto target = new RoleDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setCreationDate(source.getCreationDate());
        return target;
    }
}
