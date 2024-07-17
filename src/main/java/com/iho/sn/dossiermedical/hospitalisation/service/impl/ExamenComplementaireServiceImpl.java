package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;
import com.iho.sn.dossiermedical.hospitalisation.repository.ExamenComplementaireRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.ExamenComplementaireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamenComplementaireServiceImpl implements ExamenComplementaireService {

    private final ExamenComplementaireRepository examenComplementaireRepository;

    @Override
    public ExamenComplementaire saveExamenComplementaire(ExamenComplementaire examen) {
        return examenComplementaireRepository.save(examen);
    }

    @Override
    public ExamenComplementaire updateExamenComplementaire(Long id, ExamenComplementaire examen) {
        examen.setId(id);
        return examenComplementaireRepository.save(examen);
    }

    @Override
    public ExamenComplementaire findById(Long id) {
        return examenComplementaireRepository.findExamenComplementaireById(id);
    }

    @Override
    public List<ExamenComplementaire> findAllExamenComplementaires() {
        return examenComplementaireRepository.findAllExamenComplementaires();
    }

    @Override
    public void deleteExamenComplementaire(Long id) {
        ExamenComplementaire examenComplementaire = findById(id);
        examenComplementaireRepository.save(examenComplementaire);
    }
}