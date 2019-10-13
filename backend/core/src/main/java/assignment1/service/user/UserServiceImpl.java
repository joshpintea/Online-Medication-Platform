package assignment1.service.user;

import assignment1.entities.User;
import assignment1.repository.UserRepository;
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
}
