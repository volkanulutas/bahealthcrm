package tr.com.bacompany.bahealthcrm.data.dto;

import tr.com.bacompany.bahealthcrm.data.entity.helper.Address;
import tr.com.bacompany.bahealthcrm.data.entity.helper.TelephoneNumber;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class AgencyDto implements Serializable {
    private Long id;

    private String name;

    private Set<TelephoneNumber> telephoneNumberList = new HashSet<>();

    private Set<Address> addressList = new HashSet<>();
}
