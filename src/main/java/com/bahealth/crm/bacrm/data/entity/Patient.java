package com.bahealth.crm.bacrm.data.entity;

import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
import com.bahealth.crm.bacrm.data.entity.treatment.Treatment;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String middleName;

    @Column
    private String surname;

    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<TelephoneNumber> telephoneNumbers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id"))
    private Set<Treatment> treatments = new HashSet<>();
}
