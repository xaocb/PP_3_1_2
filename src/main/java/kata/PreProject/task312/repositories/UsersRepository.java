package kata.PreProject.task312.repositories;

import kata.PreProject.task312.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
