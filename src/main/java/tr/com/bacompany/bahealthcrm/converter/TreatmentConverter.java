package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import tr.com.bacompany.bahealthcrm.data.dto.TreatmentDto;
import tr.com.bacompany.bahealthcrm.data.entity.Patient;
import tr.com.bacompany.bahealthcrm.data.entity.treatment.Treatment;

import java.util.Set;
import java.util.stream.Collectors;

public class TreatmentConverter {
    public static Treatment toEntity(TreatmentDto source) {
        Treatment target = new Treatment();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        Set<Patient> patients = source.getPatients().stream().map(PatientConverter::toEntity).collect(Collectors.toSet());
        target.setPatients(patients);
        target.setDate(source.getDate());
        return target;
    }

    public static TreatmentDto toDto(Treatment source) {
        TreatmentDto target = new TreatmentDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setType(source.getType());
        Set<PatientDto> patients = source.getPatients().stream().map(PatientConverter::toDto).collect(Collectors.toSet());
        target.setPatients(patients);
        target.setDate(source.getDate());
        return target;
    }
}
