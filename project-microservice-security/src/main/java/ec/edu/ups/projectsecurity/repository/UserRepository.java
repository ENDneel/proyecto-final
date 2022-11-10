package ec.edu.ups.projectsecurity.repository;

import ec.edu.ups.projectsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
