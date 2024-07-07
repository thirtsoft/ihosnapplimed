package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicePartenaireRepository extends JpaRepository<ServicePartenaire, Long> {

    @Query("SELECT DISTINCT m from ServicePartenaire m where m.id=:id and m.actif=1")
    ServicePartenaire findServicePartenaireById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from ServicePartenaire m where m.actif=1 ORDER BY m.id DESC")
    List<ServicePartenaire> findAll();

    @Query("SELECT m FROM ServicePartenaire m WHERE lower(m.code) = lower(:code) AND m.actif = 1")
    Optional<ServicePartenaire> findByCode(@Param("code") String code);
}
