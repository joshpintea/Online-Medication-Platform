package assg4.web_service.repositories;

import assg4.web_service.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>{
    public User getUserByUsername(String username);
}
