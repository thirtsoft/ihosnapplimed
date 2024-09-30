package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.DermatoseAutoimine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DermatoseAutoimineRepository extends JpaRepository<DermatoseAutoimine, Long> {

    @Query("SELECT DISTINCT m from DermatoseAutoimine m where m.id=:id and m.actif=1")
    DermatoseAutoimine findDermatoseAutoimineById(@Param("id") Long id);

    @Query("SELECT m FROM DermatoseAutoimine m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    DermatoseAutoimine findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT DISTINCT m from DermatoseAutoimine m where m.actif=1 ORDER BY m.id DESC")
    List<DermatoseAutoimine> findAll();
}
