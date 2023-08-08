package com.bahealth.crm.bacrm.data.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelephoneNumberDto implements Serializable {
    private Long id;

    private String countryCode;

    private String telephoneNumber;
}
