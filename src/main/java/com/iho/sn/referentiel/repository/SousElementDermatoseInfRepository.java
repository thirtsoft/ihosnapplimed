package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.SousElementDermatoseInf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SousElementDermatoseInfRepository extends JpaRepository<SousElementDermatoseInf, Long> {

    @Query("SELECT DISTINCT m from SousElementDermatoseInf m where m.id=:id and m.actif=1")
    SousElementDermatoseInf findSousElementDermatoseInfById(@Param("id") Long id);

    @Query("SELECT m FROM SousElementDermatoseInf m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    SousElementDermatoseInf findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from SousElementDermatoseInf m where m.actif=1 ORDER BY m.id DESC")
    List<SousElementDermatoseInf> findAll();
}
