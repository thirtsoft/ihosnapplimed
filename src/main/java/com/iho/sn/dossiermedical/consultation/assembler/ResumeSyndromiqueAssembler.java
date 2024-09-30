package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.ResumeSyndromique;
import com.iho.sn.dossiermedical.consultation.remote.model.ResumeSyndromiqueDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResumeSyndromiqueAssembler {

    public List<ResumeSyndromiqueDs> assembleEntitiesFrom(List<ResumeSyndromique> resumeSyndromiques) {
        return resumeSyndromiques.stream().map(this::assembleFromEntityToDs).toList();
    }

    public ResumeSyndromiqueDs assembleFromEntityToDs(ResumeSyndromique resumeSyndromique) {
        ResumeSyndromiqueDs resumeSyndromiqueDs = new ResumeSyndromiqueDs();
        resumeSyndromiqueDs.setResume(resumeSyndromique.getResume());
        return resumeSyndromiqueDs;
    }

    public ResumeSyndromique assembleAntecedentFromDs(ResumeSyndromiqueDs resumeSyndromiqueDs) {
        ResumeSyndromique resumeSyndromique = new ResumeSyndromique();
        resumeSyndromiqueDs.setResume(resumeSyndromique.getResume());
        return resumeSyndromique;
    }

    public ResumeSyndromique assembleUpdateEntityFromDs(ResumeSyndromique resumeSyndromique, ResumeSyndromiqueDs resumeSyndromiqueDs) {
        resumeSyndromiqueDs.setResume(resumeSyndromique.getResume());
        return resumeSyndromique;
    }
}
