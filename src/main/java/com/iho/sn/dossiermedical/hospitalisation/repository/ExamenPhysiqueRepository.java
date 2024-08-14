package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenPhysique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenPhysiqueRepository extends JpaRepository<ExamenPhysique, Long> {

    @Query("SELECT DISTINCT ep from ExamenPhysique ep where ep.id=:id ")
    ExamenPhysique findExamenPhysiqueById(@Param("id") Long id);

    @Query("SELECT DISTINCT ep from ExamenPhysique ep where ep.observationClinique.id=:id")
    List<ExamenPhysique> findAllExamenPhysiquesByObservationCliniqueId(@Param("id") Long id);
}