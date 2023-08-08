package com.bahealth.crm.bacrm.data.entity;

import com.bahealth.crm.bacrm.data.entity.helper.Address;
import com.bahealth.crm.bacrm.data.entity.helper.TelephoneNumber;
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
@Table(name = "AGENCY")
public class Agency {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<TelephoneNumber> telephoneNumbers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<Address> addresses = new HashSet<>();
}
