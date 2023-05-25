package kata.PreProject.task312.service;

import kata.PreProject.task312.models.User;
import kata.PreProject.task312.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }


    @Override
    public User getUserInfo(long id) {
        Optional<User> getUser = usersRepository.findById(id);
        return getUser.orElse(null);
    }

    @Transactional
    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        usersRepository.deleteById(id);
    }
}
