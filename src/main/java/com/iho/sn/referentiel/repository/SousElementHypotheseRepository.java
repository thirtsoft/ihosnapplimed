package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.SousElementHypothese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SousElementHypotheseRepository extends JpaRepository<SousElementHypothese, Long> {

    @Query("SELECT DISTINCT m from SousElementHypothese m where m.id=:id and m.actif=1")
    SousElementHypothese findSousElementHypotheseById(@Param("id") Long id);

    @Query("SELECT m FROM SousElementHypothese m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    SousElementHypothese findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from SousElementHypothese m where m.actif=1 ORDER BY m.id DESC")
    List<SousElementHypothese> findAll();
}
