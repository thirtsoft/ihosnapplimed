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
public class ConsultationMedicalDs {

    private Long id;

    private String numeroConsultation;

    private String code;

    private LocalDate dateConsultation;

    //  private ExamenPhysiqueDs examenPhysiqueDs;

    private ConstancePhysiqueDs constancePhysiqueDs;

    private int typePatient;

//    private InterrogationDs interrogationDs;

    private List<ElementRechercheNotionDs> elementRechercheNotions;

    private List<ElementPlainteDs> elementPlaintes;

    private List<ElementTerrainDs> elementTerrains;

//    private ExamenDermatologiqueDs examenDermatologiqueDs;

    private List<ElementExamenDermatologiqueDs> elementExamenDermatologiques;

    private ExamenAppareilDs examenAppareilDs;

    private ResumeSyndromiqueDs resumeSyndromiqueDs;

    private BilanParacliniqueDs bilanParacliniqueDs;

    //   private HypotheseDiagnostiqueDs hypotheseDiagnostiqueDs;

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
