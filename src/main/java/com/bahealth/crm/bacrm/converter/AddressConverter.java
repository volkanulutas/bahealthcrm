package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.AddressDto;
import com.bahealth.crm.bacrm.data.entity.helper.Address;

public class AddressConverter {
    public static Address toEntity(AddressDto source) {
        Address target = new Address();
        target.setId(source.getId());
        target.setAddress(source.getAddress());
        target.setCountry(source.getCountry());
        return target;
    }

    public static AddressDto toDto(Address source) {
        AddressDto target = new AddressDto();
        target.setId(source.getId());
        target.setAddress(source.getAddress());
        target.setCountry(source.getCountry());
        return target;
    }
}
