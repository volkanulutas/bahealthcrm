package tr.com.bacompany.bahealthcrm.converter.user;

import tr.com.bacompany.bahealthcrm.data.dto.user.RoleDto;
import tr.com.bacompany.bahealthcrm.data.entity.user.Role;

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
