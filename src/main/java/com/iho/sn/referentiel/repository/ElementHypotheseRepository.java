package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.ElementHypothese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementHypotheseRepository extends JpaRepository<ElementHypothese, Long> {

    @Query("SELECT DISTINCT m from ElementHypothese m where m.id=:id and m.actif=1")
    ElementHypothese findElementHypotheseById(@Param("id") Long id);

    @Query("SELECT m FROM ElementHypothese m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    ElementHypothese findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from ElementHypothese m where m.actif=1 ORDER BY m.id DESC")
    List<ElementHypothese> findAll();
}
