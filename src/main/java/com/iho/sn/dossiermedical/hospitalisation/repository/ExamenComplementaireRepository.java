package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamenComplementaireRepository extends JpaRepository<ExamenComplementaire, Long> {

    @Query("SELECT DISTINCT e from ExamenComplementaire e where e.id=:id")
    ExamenComplementaire findExamenComplementaireById(@Param("id") Long id);

    @Query("SELECT DISTINCT e from ExamenComplementaire e")
    List<ExamenComplementaire> findAllExamenComplementaires();
}