package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedicalItem;
import com.iho.sn.dossiermedical.hospitalisation.repository.TraitementMedicalItemRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.TraitementMedicalRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.TraitementMedicalService;
import com.iho.sn.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TraitementMedicalServiceImpl implements TraitementMedicalService {

    private final TraitementMedicalRepository traitementMedicalRepository;
    private final TraitementMedicalItemRepository traitementMedicalItemRepository;

    @Override
    public TraitementMedical saveTraitementMedical(TraitementMedical traitementMedical) {
        return traitementMedicalRepository.save(traitementMedical);
    }

    @Override
    public TraitementMedical updateTraitementMedical(Long id, TraitementMedical traitementMedical) {
        return traitementMedicalRepository.save(traitementMedical);
    }

    @Override
    public TraitementMedical findById(Long id) {
        return traitementMedicalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Traitement not found"));
    }

    @Override
    public List<TraitementMedical> findAllTraitementMedicals() {
        return traitementMedicalRepository.findAll();
    }

    @Override
    public void deleteTraitementMedical(Long id) {
        TraitementMedical traitementMedical = findById(id);
        traitementMedicalRepository.delete(traitementMedical);
    }

    @Override
    public TraitementMedicalItem findTraitementMedicalItemById(Long id) {
        return traitementMedicalItemRepository.findById(id).orElse(null);
    }

    @Override
    public TraitementMedicalItem saveTraitementMedicalItem(TraitementMedicalItem traitementMedicalItem) {
        return traitementMedicalItemRepository.save(traitementMedicalItem);
    }
}