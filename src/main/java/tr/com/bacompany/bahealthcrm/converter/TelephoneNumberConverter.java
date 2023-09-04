package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.TelephoneNumberDto;
import tr.com.bacompany.bahealthcrm.data.entity.helper.TelephoneNumber;
import org.springframework.stereotype.Component;

@Component
public class TelephoneNumberConverter {
    public static TelephoneNumber toEntity(TelephoneNumberDto source) {
        TelephoneNumber target = new TelephoneNumber();
        target.setId(source.getId());
        target.setCountryCode(source.getCountryCode());
        target.setTelephoneNumber(source.getTelephoneNumber());
        return target;
    }

    public static TelephoneNumberDto toDto(TelephoneNumber source) {
        TelephoneNumberDto target = new TelephoneNumberDto();
        target.setId(source.getId());
        target.setCountryCode(source.getCountryCode());
        target.setTelephoneNumber(source.getTelephoneNumber());
        return target;
    }
}
