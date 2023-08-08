package com.bahealth.crm.bacrm.converter;

import com.bahealth.crm.bacrm.data.dto.TelephoneNumberDto;
import com.bahealth.crm.bacrm.data.dto.form.FormMessageDto;
import com.bahealth.crm.bacrm.data.entity.form.Form;
import com.bahealth.crm.bacrm.data.entity.form.FormMessage;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import org.springframework.stereotype.Component;

public class FormMessageConverter {
    public static FormMessage toEntity(FormMessageDto source) {
        FormMessage target = new FormMessage();
        target.setId(source.getId());
        target.setMessage(source.getMessage());
        target.setDate(source.getDate());
        return  target;
    }

    public static FormMessageDto toDto(FormMessage source){
        FormMessageDto target = new FormMessageDto();
        target.setId(source.getId());
        target.setMessage(source.getMessage());
        target.setDate(source.getDate());
        return target;
    }
}
