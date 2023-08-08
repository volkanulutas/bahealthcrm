package com.bahealth.crm.bacrm.data.entity;

import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import com.bahealth.crm.bacrm.data.entity.treatment.TreatmentType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<TelephoneNumber> telephoneNumberList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<Address> addressList = new HashSet<>();

    @ElementCollection(targetClass = TreatmentType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "hospital_treatment")
    @Column(name = "treatment")
    private Set<TreatmentType> treatmentTypeList = new HashSet<>();
}
