package com.bahealth.crm.bacrm.data.entity.treatment;

import com.bahealth.crm.bacrm.data.entity.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TREATMENT")
public class Treatment {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private TreatmentType type;

    @Column
    private Long date;

    @ManyToMany(mappedBy = "treatments")
    private Set<Patient> patients = new HashSet<>();
}
