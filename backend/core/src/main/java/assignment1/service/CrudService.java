package assignment1.service;

import assignment1.exception.ObjectNotFound;
import assignment1.exception.UsernameIsTaken;

import java.util.List;

public interface CrudService<Dto> {
    List<Dto> getAll();
    Dto getOne(Long id) throws ObjectNotFound;
    void delete(Long id) throws ObjectNotFound;

    /**
     * if id is set then the object is updated.
     * else a new obj of this type is created
     * @param obj
     * @return
     */
    Dto save(Dto obj) throws UsernameIsTaken;
}
