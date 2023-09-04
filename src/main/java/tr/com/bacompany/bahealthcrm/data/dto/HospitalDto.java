package tr.com.bacompany.bahealthcrm.data.dto;

import tr.com.bacompany.bahealthcrm.data.entity.helper.Address;
import tr.com.bacompany.bahealthcrm.data.entity.helper.TelephoneNumber;
import tr.com.bacompany.bahealthcrm.data.entity.treatment.TreatmentType;
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
