package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.Synthese;
import com.iho.sn.dossiermedical.hospitalisation.repository.SyntheseRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.SyntheseService;
import com.iho.sn.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SyntheseServiceImpl implements SyntheseService {

    private final SyntheseRepository syntheseRepository;

    @Override
    public Synthese saveSynthese(Synthese synthese) {
        return syntheseRepository.save(synthese);
    }

    @Override
    public Synthese updateSynthese(Long id, Synthese synthese) {
        if (!syntheseRepository.existsById(id)) {
            throw new EntityNotFoundException("This Systhese that id is " + id + "not found");
        }
        synthese.setId(id);
        return syntheseRepository.save(synthese);
    }

    @Override
    public Synthese findById(Long id) {
        return syntheseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("syhnthe.notFound"));
    }

    @Override
    public List<Synthese> findAllSyntheses() {
        return syntheseRepository.findAllSyntheses();
    }

    @Override
    public void deleteSynthese(Long id) {
        Synthese synthese = syntheseRepository.findSyntheseById(id);
        syntheseRepository.delete(synthese);
    }
}