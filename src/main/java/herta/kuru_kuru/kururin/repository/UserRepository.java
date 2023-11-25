package herta.kuru_kuru.kururin.repository;

import herta.kuru_kuru.kururin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
