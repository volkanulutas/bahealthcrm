package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.AddressDto;
import tr.com.bacompany.bahealthcrm.data.entity.helper.Address;

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
