package com.iho.sn.dossiermedical.hospitalisation.service;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedicalItem;

import java.util.List;

public interface TraitementMedicalService {

    TraitementMedical saveTraitementMedical(TraitementMedical traitementMedical);

    TraitementMedical updateTraitementMedical(Long id, TraitementMedical traitementMedical);

    TraitementMedical findById(Long id);

    List<TraitementMedical> findAllTraitementMedicals();

    void deleteTraitementMedical(Long id);

    TraitementMedicalItem findTraitementMedicalItemById(Long id);

    TraitementMedicalItem saveTraitementMedicalItem(TraitementMedicalItem traitementMedicalItem);
}