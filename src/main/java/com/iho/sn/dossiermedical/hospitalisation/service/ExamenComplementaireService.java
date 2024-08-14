package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;

import java.util.List;

public interface ExamenComplementaireService {

    ExamenComplementaire saveExamenComplementaire(ExamenComplementaire examen);

    ExamenComplementaire updateExamenComplementaire(Long id, ExamenComplementaire examen);

    ExamenComplementaire findById(Long id);

    List<ExamenComplementaire> findAllExamenComplementaires();

    void deleteExamenComplementaire(Long id);
}