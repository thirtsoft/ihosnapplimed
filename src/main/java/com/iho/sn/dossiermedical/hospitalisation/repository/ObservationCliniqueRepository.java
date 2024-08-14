package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ObservationCliniqueRepository extends JpaRepository<ObservationClinique, Long> {

    @Query("SELECT DISTINCT oc from ObservationClinique oc where oc.id=:id")
    Optional<ObservationClinique> findObservationCliniqueById(@Param("id") Long id);

    @Query("SELECT DISTINCT oc from ObservationClinique oc order by oc.id desc")
    List<ObservationClinique> findAllObservationCliniques();
}