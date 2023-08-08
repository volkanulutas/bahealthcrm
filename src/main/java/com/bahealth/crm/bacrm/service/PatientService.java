package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.PatientDto;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;
import com.bahealth.crm.bacrm.data.exception.ValidationException;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PatientService {
    PatientDto save(PatientDto patientDto) throws ValidationException, ResourceNotFoundException;

    Page<PatientDto> getAll(int page, int size);

    Optional<PatientDto> get(Long id) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;
}
