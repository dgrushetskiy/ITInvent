package ru.gothmog.itinvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.itinvent.model.entity.auth.Role;

/**
 * @author d.grushetskiy
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
