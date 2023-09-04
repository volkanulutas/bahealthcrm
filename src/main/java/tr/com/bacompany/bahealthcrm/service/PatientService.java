package tr.com.bacompany.bahealthcrm.service;

import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import tr.com.bacompany.bahealthcrm.data.exception.ResourceNotFoundException;
import tr.com.bacompany.bahealthcrm.data.exception.ValidationException;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PatientService {
    PatientDto save(PatientDto patientDto) throws ValidationException, ResourceNotFoundException;

    Page<PatientDto> getAll(int page, int size);

    Optional<PatientDto> get(Long id) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;
}
