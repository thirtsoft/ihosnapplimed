package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementMedicalRepository extends JpaRepository<TraitementMedical, Long> {
}