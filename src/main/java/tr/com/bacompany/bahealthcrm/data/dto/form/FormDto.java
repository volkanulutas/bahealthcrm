package tr.com.bacompany.bahealthcrm.data.dto.form;

import tr.com.bacompany.bahealthcrm.data.dto.PatientDto;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class FormDto implements Serializable {
    private Long id;

    private Set<FormMessageDto> ongoingMessageList = new HashSet<>();

    private Set<FormMessageDto> incomingMessageList = new HashSet<>();

    private PatientDto patient;

    private Long date;
}
