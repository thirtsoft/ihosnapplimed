package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    @Query("SELECT DISTINCT m from Chambre m where m.id=:id and m.actif=1")
    Chambre findChambreById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from Chambre m where m.actif=1 ORDER BY m.id DESC")
    List<Chambre> findAll();

    @Query("SELECT m FROM Chambre m WHERE lower(m.code) = lower(:code) AND m.actif = 1")
    Optional<Chambre> findByCode(@Param("code") String code);

    @Query("SELECT m FROM Chambre m WHERE lower(m.libelle) = lower(:libelle) AND m.actif = 1")
    Optional<Chambre> findByLibelle(@Param("libelle") String libelle);
}
