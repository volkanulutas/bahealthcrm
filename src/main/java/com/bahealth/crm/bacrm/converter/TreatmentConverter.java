package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.PatientDto;
import com.bahealth.crm.bacrm.data.dto.TreatmentDto;
import com.bahealth.crm.bacrm.data.entity.Patient;
import com.bahealth.crm.bacrm.data.entity.treatment.Treatment;

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
