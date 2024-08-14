package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedicalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementMedicalItemRepository extends JpaRepository<TraitementMedicalItem, Long> {
}