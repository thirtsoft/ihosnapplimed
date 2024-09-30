package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.ElementExamenDermatologique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementExamenDermatologiqueRepository extends JpaRepository<ElementExamenDermatologique, Long> {

    @Query("SELECT DISTINCT m from ElementExamenDermatologique m where m.id=:id and m.actif=1")
    ElementExamenDermatologique findElementExamenDermatologiqueById(@Param("id") Long id);

    @Query("SELECT m FROM ElementExamenDermatologique m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    ElementExamenDermatologique findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from ElementExamenDermatologique m where m.actif=1 ORDER BY m.id DESC")
    List<ElementExamenDermatologique> findAll();
}
