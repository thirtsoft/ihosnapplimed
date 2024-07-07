package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupeSanguinRepository extends JpaRepository<GroupeSanguin, Long> {

    @Query("SELECT DISTINCT m from GroupeSanguin m where m.id=:id and m.actif=1")
    GroupeSanguin findGroupeSanguinById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from GroupeSanguin m where m.actif=1 ORDER BY m.id DESC")
    List<GroupeSanguin> findAll();

    @Query("SELECT m FROM Chambre m WHERE lower(m.code) = lower(:code) AND m.actif = 1")
    Optional<GroupeSanguin> findByCode(@Param("code") String code);

}
