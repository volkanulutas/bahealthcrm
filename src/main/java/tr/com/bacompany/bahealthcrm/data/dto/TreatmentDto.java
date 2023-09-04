package tr.com.bacompany.bahealthcrm.data.dto;

import tr.com.bacompany.bahealthcrm.data.entity.treatment.TreatmentType;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class TreatmentDto implements Serializable {
    private Long id;

    private String name;

    private TreatmentType type;

    private Long date;

    private Set<PatientDto> patients = new HashSet<>();
}
