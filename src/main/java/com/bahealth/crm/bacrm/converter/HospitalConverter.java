package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.TelephoneNumberDto;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;

public class HospitalConverter {
    public TelephoneNumber toEntity(TelephoneNumberDto source) {
        TelephoneNumber target = new TelephoneNumber();
        target.setId(source.getId());
        target.setCountryCode(source.getCountryCode());
        target.setTelephoneNumber(source.getTelephoneNumber());
        return target;
    }

    public TelephoneNumberDto toDto(TelephoneNumber source) {
        TelephoneNumberDto target = new TelephoneNumberDto();
        target.setCountryCode(source.getCountryCode());
        target.setTelephoneNumber(source.getTelephoneNumber());
        return target;
    }
}
