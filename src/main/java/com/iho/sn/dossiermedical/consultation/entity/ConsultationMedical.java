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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_consultation_medical")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ConsultationMedical extends AbstractAuditableEntity implements Serializable {

    @Column(name = "patient_uid")
    private String code;

    @Column(name = "numero_consultation", nullable = false, unique = true)
    private int numeroConsultation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate dateConsultation;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "constance_physique_uid")
    private ConstancePhysique constancePhysique;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementrecherchenotion_consultationmedical",
            joinColumns = @JoinColumn(name = "consultation_medical_uid"))
    @Column(name = "element_recherche_notion_uid")
    private Set<Long> elementRechercheNotions;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementterrain_consultationmedical",
            joinColumns = @JoinColumn(name = "consultation_medical_uid"))
    @Column(name = "element_terrain_uid")
    private Set<Long> elementTerrains;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementplainte_consultationmedical",
            joinColumns = @JoinColumn(name = "consultation_medical_uid"))
    @Column(name = "element_plainte_uid")
    private Set<Long> elementPlaintes;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "elementexamendermatologique_consultationmedical",
            joinColumns = @JoinColumn(name = "consultation_medical_uid"))
    @Column(name = "element_examen_dermatologiques_uid")
    private Set<Long> elementExamenDermatologiques;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "examen_appareil_uid")
    private ExamenAppareil examenAppareil;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "resume_syndromique_uid")
    private ResumeSyndromique resumeSyndromique;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "bilan_paraclinique_uid")
    private BilanParaclinique bilanParaclinique;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "elementhypothese_consultationmedical",
            joinColumns = @JoinColumn(name = "consultation_medical_uid"),
            inverseJoinColumns = @JoinColumn(name = "element_hypothese_uid"))
    private Set<ElementHypothese> elementHypotheses;

    @Column(name = "type_patient", columnDefinition = "int default 1")
    private int typePatient;

    private int actif;

    public boolean isActif() {
        return actif == 1;
    }

    public void setActif(boolean actif) {
        if (actif)
            this.actif = 1;
        else
            this.actif = 0;
    }
}
