package com.bahealth.crm.bacrm.data.entity.helper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TELEPHONE_NUMBER")
public class TelephoneNumber {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String countryCode;

    @Column
    private String telephoneNumber;
}
