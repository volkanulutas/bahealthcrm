package com.bahealth.crm.bacrm.repository;

import com.bahealth.crm.bacrm.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
