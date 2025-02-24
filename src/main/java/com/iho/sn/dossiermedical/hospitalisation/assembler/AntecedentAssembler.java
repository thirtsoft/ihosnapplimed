package com.iho.sn.dossiermedical.hospitalisation.assembler;

import com.iho.sn.dossiermedical.hospitalisation.entity.Antecedent;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.AntecedentDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AntecedentAssembler {


    public List<AntecedentDs> assembleEntitiesFrom(List<Antecedent> antecedents) {
        return antecedents.stream().map(this::assembleEntityToDs).toList();
    }

    public AntecedentDs assembleEntityToDs(Antecedent antecedent) {
        AntecedentDs antecedentDs = new AntecedentDs();
        if (antecedent.getId() != null)
            antecedentDs.setId(antecedent.getId());
        antecedentDs.setAntecedentsMedicaux(antecedent.getAntecedentsMedicaux());
        antecedentDs.setAntecedentsChirurgicaux(antecedent.getAntecedentsChirurgicaux());
        antecedentDs.setAntecedentsGynecologiques(antecedent.getAntecedentsGynecologiques());
        antecedentDs.setAntecedentsFamilialsAscendant(antecedent.getAntecedentsFamilialsAscendant());
        antecedentDs.setAntecedentsFamilialsCollateral(antecedent.getAntecedentsFamilialsCollateral());
        antecedentDs.setAntecedentsFamilialsDescendant(antecedent.getAntecedentsFamilialsDescendant());
        antecedentDs.setModeVies(antecedent.getModeVies());
        return antecedentDs;
    }

    public Antecedent assembleAntecedentFromDs(AntecedentDs antecedentDs) {
        Antecedent antecedent = new Antecedent();
        if (antecedentDs.getId() != null)
            antecedent.setId(antecedentDs.getId());
        antecedent.setAntecedentsMedicaux(antecedentDs.getAntecedentsMedicaux());
        antecedent.setAntecedentsChirurgicaux(antecedentDs.getAntecedentsChirurgicaux());
        antecedent.setAntecedentsGynecologiques(antecedentDs.getAntecedentsGynecologiques());
        antecedent.setAntecedentsFamilialsAscendant(antecedentDs.getAntecedentsFamilialsAscendant());
        antecedent.setAntecedentsFamilialsCollateral(antecedentDs.getAntecedentsFamilialsCollateral());
        antecedent.setAntecedentsFamilialsDescendant(antecedentDs.getAntecedentsFamilialsDescendant());
        antecedent.setModeVies(antecedentDs.getModeVies());
        return antecedent;
    }

    public Antecedent assembleUpdateAntecedentFromDs(Antecedent antecedent, AntecedentDs antecedentDs) {
        antecedent.setAntecedentsMedicaux(antecedentDs.getAntecedentsMedicaux());
        antecedent.setAntecedentsChirurgicaux(antecedentDs.getAntecedentsChirurgicaux());
        antecedent.setAntecedentsGynecologiques(antecedentDs.getAntecedentsGynecologiques());
        antecedent.setAntecedentsFamilialsAscendant(antecedentDs.getAntecedentsFamilialsAscendant());
        antecedent.setAntecedentsFamilialsCollateral(antecedentDs.getAntecedentsFamilialsCollateral());
        antecedent.setAntecedentsFamilialsDescendant(antecedentDs.getAntecedentsFamilialsDescendant());
        antecedent.setModeVies(antecedentDs.getModeVies());
        return antecedent;
    }
}