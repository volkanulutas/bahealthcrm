package tr.com.bacompany.bahealthcrm.repository;

import tr.com.bacompany.bahealthcrm.data.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {}
