package assignment1.service.user;

import assignment1.entities.User;

public interface UserService {
    User getUserAfterUsername(String username);
    User getLoggedUser();
}
