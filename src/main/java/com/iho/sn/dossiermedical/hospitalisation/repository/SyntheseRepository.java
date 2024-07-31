package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.Synthese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SyntheseRepository extends JpaRepository<Synthese, Long> {

    @Query("SELECT DISTINCT s from Synthese s where s.id=:id")
    Synthese findSyntheseById(@Param("id") Long id);

    @Query("SELECT DISTINCT s from Synthese s")
    List<Synthese> findAllSyntheses();
}