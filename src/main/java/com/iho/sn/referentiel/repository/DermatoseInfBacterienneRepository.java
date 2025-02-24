package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseInfBacterienne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseInfBacterienneRepository extends JpaRepository<DermatoseInfBacterienne, Long> {

    @Query("SELECT DISTINCT m from DermatoseInfBacterienne m where m.id=:id and m.actif=1")
    DermatoseInfBacterienne findDermatoseInfBacterienneById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseInfBacterienne m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseInfBacterienne findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseInfBacterienne m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseInfBacterienne> findAll();
}
