package com.bahealth.crm.bacrm.data.dto;

import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class AgencyDto implements Serializable {
    private Long id;

    private String name;

    private Set<TelephoneNumber> telephoneNumberList = new HashSet<>();

    private Set<Address> addressList = new HashSet<>();
}
