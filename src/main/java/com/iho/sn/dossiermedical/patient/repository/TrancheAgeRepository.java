package com.iho.sn.dossiermedical.patient.repository;

import com.iho.sn.dossiermedical.patient.entity.TrancheAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrancheAgeRepository extends JpaRepository<TrancheAge, Long> {

    @Query("SELECT DISTINCT m from TrancheAge m where m.id=:id")
    TrancheAge findTrancheAgeById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from TrancheAge m ORDER BY m.id DESC")
    List<TrancheAge> findAll();

    @Query("SELECT m FROM TrancheAge m WHERE lower(m.code) = lower(:code)")
    Optional<TrancheAge> findByCode(@Param("code") String code);
}
