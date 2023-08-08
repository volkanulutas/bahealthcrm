package com.bahealth.crm.bacrm.data.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private Long id;

    private String address;

    private String city;

    private String country;
}
