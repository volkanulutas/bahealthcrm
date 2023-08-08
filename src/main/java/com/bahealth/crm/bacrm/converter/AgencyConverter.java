package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.AgencyDto;
import com.bahealth.crm.bacrm.data.entity.Agency;
import org.springframework.stereotype.Component;

@Component
public class AgencyConverter {
    public static Agency toEntity(AgencyDto source) {
        Agency target = new Agency();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setAddresses(source.getAddressList());
        target.setTelephoneNumbers(source.getTelephoneNumberList());
        return target;
    }

    public static AgencyDto toDto(Agency source) {
        AgencyDto target = new AgencyDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setAddressList(source.getAddresses());
        target.setTelephoneNumberList(source.getTelephoneNumbers());
        return target;
    }
}
