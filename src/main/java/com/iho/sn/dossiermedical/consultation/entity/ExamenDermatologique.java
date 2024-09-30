package com.iho.sn.dossiermedical.consultation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_examen_dermatologique")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExamenDermatologique extends AbstractAuditableEntity implements Serializable {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementexamendermatologique_examendermatologique",
            joinColumns = @JoinColumn(name = "examen_dermatologique_uid"))
    @Column(name = "element_examen_dermatologiques_uid")
    private Set<Long> elementExamenDermatologiques;

}