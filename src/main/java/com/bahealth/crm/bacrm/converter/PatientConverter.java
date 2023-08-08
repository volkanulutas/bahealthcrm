package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.AddressDto;
import com.bahealth.crm.bacrm.data.dto.PatientDto;
import com.bahealth.crm.bacrm.data.dto.TelephoneNumberDto;
import com.bahealth.crm.bacrm.data.dto.TreatmentDto;
import com.bahealth.crm.bacrm.data.entity.Patient;
import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import com.bahealth.crm.bacrm.data.entity.treatment.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PatientConverter {

    public static Patient toEntity(PatientDto source) {
        Patient target = new Patient();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setMiddleName(source.getMiddleName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        Set<TelephoneNumber> telephoneNumbers =
                source.getTelephoneNumbers().stream().map(TelephoneNumberConverter::toEntity).collect(Collectors.toSet());
        target.setTelephoneNumbers(telephoneNumbers);
        Set<Address> addressList = source.getAddresses().stream().map(AddressConverter::toEntity).collect(Collectors.toSet());
        target.setAddresses(addressList);
        Set<Treatment> treatmentList = source.getTreatments().stream().map(TreatmentConverter::toEntity).collect(Collectors.toSet());
        target.setTreatments(treatmentList);
        return target;
    }

    public static PatientDto toDto(Patient source) {
        PatientDto target = new PatientDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setMiddleName(source.getMiddleName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        Set<TelephoneNumberDto> telephoneNumbers =
                source.getTelephoneNumbers().stream().map(TelephoneNumberConverter::toDto).collect(Collectors.toSet());
        target.setTelephoneNumbers(telephoneNumbers);
        Set<AddressDto> addresses = source.getAddresses().stream().map(AddressConverter::toDto).collect(Collectors.toSet());
        target.setAddresses(addresses);
        Set<TreatmentDto> treatmentList = source.getTreatments().stream().map(TreatmentConverter::toDto).collect(Collectors.toSet());
        target.setTreatments(treatmentList);
        return target;
    }
}
