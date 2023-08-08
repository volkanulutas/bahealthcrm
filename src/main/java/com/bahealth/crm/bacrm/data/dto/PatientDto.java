package com.bahealth.crm.bacrm.data.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PatientDto implements Serializable {
    private Long id;

    private String name;

    private String middleName;

    private String surname;

    private String email;

    private Set<TelephoneNumberDto> telephoneNumbers = new HashSet<>();

    private Set<AddressDto> addresses = new HashSet<>();

    private Set<TreatmentDto> treatments = new HashSet<>();
}
