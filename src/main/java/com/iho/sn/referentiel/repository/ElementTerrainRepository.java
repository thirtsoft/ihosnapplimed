package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.ElementTerrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementTerrainRepository extends JpaRepository<ElementTerrain, Long> {

    @Query("SELECT DISTINCT m from ElementTerrain m where m.id=:id and m.actif=1")
    ElementTerrain findElementTerrainById(@Param("id") Long id);

    @Query("SELECT m FROM ElementTerrain m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    ElementTerrain findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from ElementTerrain m where m.actif=1 ORDER BY m.id DESC")
    List<ElementTerrain> findAll();
}
