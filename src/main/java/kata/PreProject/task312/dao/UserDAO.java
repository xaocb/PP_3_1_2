package kata.PreProject.task312.dao;

import kata.PreProject.task312.models.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserDAO {
    List<User> findAllUsers();

    User getUserInfo(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);

}
