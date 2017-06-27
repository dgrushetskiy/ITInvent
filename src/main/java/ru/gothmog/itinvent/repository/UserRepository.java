package ru.gothmog.itinvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.itinvent.model.entity.auth.User;

/**
 * @author d.grushetskiy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
