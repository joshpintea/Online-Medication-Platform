package assignment1.dto.mapper;

import assignment1.dto.UserDto;
import assignment1.entities.User;

public class UserMapper {

    public static UserDto convertToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getGender(),
                user.getAddress(),
                user.getName(),
                user.getBirthDate(),
                UserRoleMapper.convertToDto(user.getRole())
        );
    }
}
