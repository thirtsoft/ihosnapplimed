package com.iho.sn.dossiermedical.consultation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import com.iho.sn.referentiel.entity.ElementHypothese;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_hypothese_diagnostique")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HypotheseDiagnostique extends AbstractAuditableEntity implements Serializable {

    /*
    @Column(name = "dermatologie_inflammatoire")
    private int dermatologieInf;*/

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementhypothese_hypothesediagnostique",
            joinColumns = @JoinColumn(name = "hypothese_diagnostique_uid"))
    @Column(name = "element_hypothese_uid")
    private Set<Long> elementHypotheses;
}
