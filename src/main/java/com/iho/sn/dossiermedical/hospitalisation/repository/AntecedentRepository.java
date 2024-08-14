package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.Antecedent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntecedentRepository extends JpaRepository<Antecedent, Long> {
}