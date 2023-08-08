package com.bahealth.crm.bacrm.service;

import com.bahealth.crm.bacrm.data.dto.PatientDto;
import com.bahealth.crm.bacrm.data.exception.ResourceNotFoundException;
import com.bahealth.crm.bacrm.data.exception.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Override
    public PatientDto save(PatientDto patientDto) throws ValidationException, ResourceNotFoundException {
        return null;
    }

    @Override
    public Page<PatientDto> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<PatientDto> get(Long id) throws ResourceNotFoundException {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
    }
}
