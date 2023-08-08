package com.bahealth.crm.bacrm.data.dto.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class FormMessageDto implements Serializable {
    private Long id;

    private String message;

    private Long date;
}
