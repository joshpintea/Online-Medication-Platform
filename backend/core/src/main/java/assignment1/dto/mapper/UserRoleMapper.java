package assignment1.dto.mapper;

import assignment1.dto.UserRoleDto;
import assignment1.entities.UserRole;

public class UserRoleMapper  {

    public static UserRoleDto convertToDto(UserRole userRole) {
        if (userRole.equals(UserRole.ROLE_CAREGIVER)) {
            return UserRoleDto.ROLE_CAREGIVER;
        }

        if (userRole.equals(UserRole.ROLE_DOCTOR)) {
            return UserRoleDto.ROLE_DOCTOR;
        }

        return UserRoleDto.ROLE_PATIENT;
    }

    public static UserRole convertToEntity(UserRoleDto userRole) {
        if (userRole.equals(UserRoleDto.ROLE_CAREGIVER)) {
            return UserRole.ROLE_CAREGIVER;
        }

        if (userRole.equals(UserRoleDto.ROLE_DOCTOR)) {
            return UserRole.ROLE_DOCTOR;
        }

        return UserRole.ROLE_PATIENT;
    }
}
