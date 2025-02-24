package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    @Query("SELECT DISTINCT m from Medicament m where m.id=:id and m.actif=1")
    Medicament findCategoryMedicamentById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from Medicament m where m.actif=1 ORDER BY m.id DESC")
    List<Medicament> findAll();

    @Query("SELECT m FROM Medicament m WHERE lower(m.code) = lower(:code) AND m.actif = 1")
    Optional<Medicament> findByCode(@Param("code") String code);
}
