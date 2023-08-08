package com.bahealth.crm.bacrm.data.entity.form;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "FORM_MESSAGE")
public class FormMessage {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private String message;

    @Column
    private Long date;
}
