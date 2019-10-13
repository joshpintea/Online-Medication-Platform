package assignment1.repository;

import assignment1.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>{
    public User getUserByUsername(String username);
}
