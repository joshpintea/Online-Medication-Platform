package assignment1.service.user;

import assignment1.entities.User;
import assignment1.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserAfterUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public User getLoggedUser() {
        User user = null;
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication authentication = contextHolder.getAuthentication();

        if (authentication.getName() != null) {
            user = this.userRepository.getUserByUsername(authentication.getName());
        }

        return user;
    }
}
