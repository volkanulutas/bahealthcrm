package com.bahealth.crm.bacrm.data.dto;

import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import com.bahealth.crm.bacrm.data.entity.treatment.TreatmentType;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class HospitalDto implements Serializable {
    private Long id;

    private String name;

    private List<TelephoneNumber> telephoneNumberList = new ArrayList<>();

    private List<Address> addressList = new ArrayList<>();

    private List<TreatmentType> treatmentTypeList = new ArrayList<>();
}
