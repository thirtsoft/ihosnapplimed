package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.ElementPlainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementPlainteRepository extends JpaRepository<ElementPlainte, Long> {

    @Query("SELECT DISTINCT m from ElementPlainte m where m.id=:id and m.actif=1")
    ElementPlainte findElementPlainteById(@Param("id") Long id);

    @Query("SELECT m FROM ElementPlainte m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    ElementPlainte findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from ElementPlainte m where m.actif=1 ORDER BY m.id DESC")
    List<ElementPlainte> findAll();
}
