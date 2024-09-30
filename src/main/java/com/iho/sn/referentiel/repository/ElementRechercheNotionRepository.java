package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.ElementRechercheNotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementRechercheNotionRepository extends JpaRepository<ElementRechercheNotion, Long> {

    @Query("SELECT DISTINCT m from ElementRechercheNotion m where m.id=:id and m.actif=1")
    ElementRechercheNotion findElementRechercheNotionById(@Param("id") Long id);

    @Query("SELECT m FROM ElementRechercheNotion m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    ElementRechercheNotion findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from ElementRechercheNotion m where m.actif=1 ORDER BY m.id DESC")
    List<ElementRechercheNotion> findAll();
}
