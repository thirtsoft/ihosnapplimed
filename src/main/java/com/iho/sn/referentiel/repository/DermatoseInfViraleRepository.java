package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseInfVirale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseInfViraleRepository extends JpaRepository<DermatoseInfVirale, Long> {

    @Query("SELECT DISTINCT m from DermatoseInfVirale m where m.id=:id and m.actif=1")
    DermatoseInfVirale findDermatoseInfViraleById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseInfVirale m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseInfVirale findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseInfVirale m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseInfVirale> findAll();
}
