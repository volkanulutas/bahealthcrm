package tr.com.bacompany.bahealthcrm.service.impl;

import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;
import tr.com.bacompany.bahealthcrm.data.exception.ValidationException;
import tr.com.bacompany.bahealthcrm.service.PatientService;
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
