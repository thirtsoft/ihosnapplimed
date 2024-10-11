package com.iho.sn.dossiermedical.consultation.remote.model;

import com.iho.sn.referentiel.remote.model.ElementExamenDermatologiqueDs;
import com.iho.sn.referentiel.remote.model.ElementHypotheseDs;
import com.iho.sn.referentiel.remote.model.ElementPlainteDs;
import com.iho.sn.referentiel.remote.model.ElementRechercheNotionDs;
import com.iho.sn.referentiel.remote.model.ElementTerrainDs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultationMedicalDetailsDs {

    private Long id;

    private String numeroConsultation;

    private String nomCompletPatient;

    private String civilitePatient;

    private String situationMatrimonial;

    private int age;

    private String telephone;

    private String indexPatient;

    private String nomCompletAgent;

    private LocalDate dateConsultation;

//    private ExamenPhysiqueDs examenPhysiqueDs;

    private ConstancePhysiqueDs constancePhysiqueDs;

    private ExamenAppareilDs examenAppareilDs;

    private ResumeSyndromiqueDs resumeSyndromiqueDs;

    private BilanParacliniqueDs bilanParacliniqueDs;

    private int typePatient;

    private String patientHospitalise;

    private List<ElementRechercheNotionDs> elementRechercheNotions;

    private List<ElementPlainteDs> elementPlaintes;

    private List<ElementTerrainDs> elementTerrains;

    private List<ElementExamenDermatologiqueDs> elementExamenDermatologiques;

    private List<ElementHypotheseDs> elementHypotheses;

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
