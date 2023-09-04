package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.TelephoneNumberDto;
import tr.com.bacompany.bahealthcrm.data.entity.helper.TelephoneNumber;

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
