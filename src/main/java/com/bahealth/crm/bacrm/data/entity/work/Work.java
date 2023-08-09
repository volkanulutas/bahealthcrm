package com.bahealth.crm.bacrm.data.entity.work;

import com.bahealth.crm.bacrm.data.entity.treatment.Treatment;
import com.bahealth.crm.bacrm.data.entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "WORK")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    private String definition;

    private WorkStatus status;

    private Long planningDate;

    private Long startDate;

    private Long endDate;

    @ManyToMany
    @JoinTable(name = "notification_roles", joinColumns = @JoinColumn(name = "work_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> notificationRoles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

}
