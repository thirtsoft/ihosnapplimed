package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.CategoryMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryMedicamentRepository extends JpaRepository<CategoryMedicament, Long> {

    @Query("SELECT DISTINCT m from CategoryMedicament m where m.id=:id and m.actif=1")
    CategoryMedicament findCategoryMedicamentById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from CategoryMedicament m where m.actif=1 ORDER BY m.id DESC")
    List<CategoryMedicament> findAll();

    @Query("SELECT m FROM CategoryMedicament m WHERE lower(m.code) = lower(:code) AND m.actif = 1")
    Optional<CategoryMedicament> findByCode(@Param("code") String code);
}
