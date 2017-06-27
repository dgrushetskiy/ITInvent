package ru.gothmog.itinvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.itinvent.model.entity.agency.Branch;


/**
 * @author d.grushetskiy
 */
@Repository("branchRepository")
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
