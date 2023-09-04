package tr.com.bacompany.bahealthcrm.converter.user;

import tr.com.bacompany.bahealthcrm.data.dto.user.RoleDto;
import tr.com.bacompany.bahealthcrm.data.dto.user.UserDto;
import tr.com.bacompany.bahealthcrm.data.entity.user.Role;
import tr.com.bacompany.bahealthcrm.data.entity.user.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserConverter {
    public static User toEntity(UserDto source) {
        User target = new User();
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        target.setName(source.getName());
        target.setMiddleName(source.getMiddleName());
        target.setSurname(source.getSurname());
        target.setEnabled(source.isEnabled());
        target.setProfilePicture(source.getProfilePicture());
        Set<Role> roles = source.getRoles().stream().map(RoleConverter::toEntity).collect(Collectors.toSet());
        target.setRoles(roles);
        return target;
    }

    public static UserDto toDto(User source) {
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        target.setName(source.getName());
        target.setMiddleName(source.getMiddleName());
        target.setSurname(source.getSurname());
        target.setEnabled(source.isEnabled());
        target.setProfilePicture(source.getProfilePicture());
        Set<RoleDto> roles = source.getRoles().stream().map(RoleConverter::toDto).collect(Collectors.toSet());
        target.setRoles(roles);
        return target;
    }
}
