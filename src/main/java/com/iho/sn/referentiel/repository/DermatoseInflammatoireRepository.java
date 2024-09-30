package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseInflammatoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseInflammatoireRepository extends JpaRepository<DermatoseInflammatoire, Long> {

    @Query("SELECT DISTINCT m from DermatoseInflammatoire m where m.id=:id and m.actif=1")
    DermatoseInflammatoire findDermatoseInflammatoireById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseInflammatoire m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseInflammatoire findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseInflammatoire m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseInflammatoire> findAll();
}
