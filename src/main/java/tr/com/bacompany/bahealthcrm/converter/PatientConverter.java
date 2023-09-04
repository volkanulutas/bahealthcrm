package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.AddressDto;
import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import tr.com.bacompany.bahealthcrm.data.dto.TelephoneNumberDto;
import tr.com.bacompany.bahealthcrm.data.dto.TreatmentDto;
import tr.com.bacompany.bahealthcrm.data.entity.Patient;
import tr.com.bacompany.bahealthcrm.data.entity.helper.Address;
import tr.com.bacompany.bahealthcrm.data.entity.helper.TelephoneNumber;
import tr.com.bacompany.bahealthcrm.data.entity.treatment.Treatment;

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
