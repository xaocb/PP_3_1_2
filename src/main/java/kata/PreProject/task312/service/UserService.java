package kata.PreProject.task312.service;


import kata.PreProject.task312.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User getUserById(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);
}
