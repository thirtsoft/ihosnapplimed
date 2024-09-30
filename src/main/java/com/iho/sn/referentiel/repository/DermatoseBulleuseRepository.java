package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseBulleuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseBulleuseRepository extends JpaRepository<DermatoseBulleuse, Long> {

    @Query("SELECT DISTINCT m from DermatoseBulleuse m where m.id=:id and m.actif=1")
    DermatoseBulleuse findDermatoseBulleuseById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseBulleuse m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseBulleuse findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseBulleuse m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseBulleuse> findAll();
}
