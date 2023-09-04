package tr.com.bacompany.bahealthcrm.converter;

import tr.com.bacompany.bahealthcrm.data.dto.form.FormMessageDto;
import tr.com.bacompany.bahealthcrm.data.entity.form.FormMessage;

public class FormMessageConverter {
    public static FormMessage toEntity(FormMessageDto source) {
        FormMessage target = new FormMessage();
        target.setId(source.getId());
        target.setMessage(source.getMessage());
        target.setDate(source.getDate());
        return target;
    }

    public static FormMessageDto toDto(FormMessage source) {
        FormMessageDto target = new FormMessageDto();
        target.setId(source.getId());
        target.setMessage(source.getMessage());
        target.setDate(source.getDate());
        return target;
    }
}
