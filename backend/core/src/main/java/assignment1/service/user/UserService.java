package assignment1.service.user;

import assignment1.dto.UserDto;
import assignment1.entities.User;
import assignment1.exception.NotLoggedUser;

public interface UserService {
    User getUserAfterUsername(String username);
    UserDto getLoggedUser() throws NotLoggedUser;
}
