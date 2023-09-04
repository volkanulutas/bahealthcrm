package tr.com.bacompany.bahealthcrm.repository;

import tr.com.bacompany.bahealthcrm.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
