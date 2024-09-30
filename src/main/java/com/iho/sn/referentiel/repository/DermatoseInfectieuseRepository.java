package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseInfectieuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseInfectieuseRepository extends JpaRepository<DermatoseInfectieuse, Long> {

    @Query("SELECT DISTINCT m from DermatoseInfectieuse m where m.id=:id and m.actif=1")
    DermatoseInfectieuse findDermatoseInfectieuseById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseInfectieuse m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseInfectieuse findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseInfectieuse m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseInfectieuse> findAll();
}
