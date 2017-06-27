package ru.gothmog.itinvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.itinvent.model.entity.agency.Company;

/**
 * @author d.grushetskiy
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
