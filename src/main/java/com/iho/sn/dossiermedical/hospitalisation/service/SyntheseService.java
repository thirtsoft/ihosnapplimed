package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.Synthese;

import java.util.List;

public interface SyntheseService {

    Synthese saveSynthese(Synthese synthese);

    Synthese updateSynthese(Long id, Synthese synthese);

    Synthese findById(Long id);

    List<Synthese> findAllSyntheses();

    void deleteSynthese(Long id);
}