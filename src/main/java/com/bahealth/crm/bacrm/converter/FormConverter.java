package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.form.FormDto;
import com.bahealth.crm.bacrm.data.dto.form.FormMessageDto;
import com.bahealth.crm.bacrm.data.entity.form.Form;
import com.bahealth.crm.bacrm.data.entity.form.FormMessage;

import java.util.Set;
import java.util.stream.Collectors;

public class FormConverter {
    public static Form toEntity(FormDto source) {
        Form target = new Form();
        target.setId(source.getId());
        target.setPatient(PatientConverter.toEntity(source.getPatient()));
        Set<FormMessage> incomingFormMessageList =
                source.getIncomingMessageList().stream().map(FormMessageConverter::toEntity).collect(Collectors.toSet());
        target.setIncomingMessages(incomingFormMessageList);
        Set<FormMessage> outgoingFormMessageList =
                source.getOngoingMessageList().stream().map(FormMessageConverter::toEntity).collect(Collectors.toSet());
        target.setOngoingMessages(outgoingFormMessageList);
        target.setDate(source.getDate());
        return target;
    }

    public static FormDto toDto(Form source) {
        FormDto target = new FormDto();
        target.setId(source.getId());
        target.setPatient(PatientConverter.toDto(source.getPatient()));
        Set<FormMessageDto> incomingFormMessageList =
                source.getIncomingMessages().stream().map(FormMessageConverter::toDto).collect(Collectors.toSet());
        target.setIncomingMessageList(incomingFormMessageList);
        Set<FormMessageDto> outgoingFormMessageList =
                source.getOngoingMessages().stream().map(FormMessageConverter::toDto).collect(Collectors.toSet());
        target.setOngoingMessageList(outgoingFormMessageList);
        target.setDate(source.getDate());
        return target;
    }
}
