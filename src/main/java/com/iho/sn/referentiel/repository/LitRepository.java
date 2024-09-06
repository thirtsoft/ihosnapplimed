package com.iho.sn.referentiel.repository;

import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LitRepository extends JpaRepository<Lit, Long> {

    @Query("SELECT DISTINCT m from Lit m where m.id=:id and m.actif=1")
    Lit findLitById(@Param("id") Long id);

    @Query("SELECT DISTINCT m from Lit m where m.actif=1 ORDER BY m.id DESC")
    List<Lit> findAll();

    @Query("SELECT m FROM Lit m WHERE lower(m.numero) = lower(:numero) AND m.actif = 1")
    Optional<Lit> findByNumero(@Param("numero") String numero);

    @Query("Select DISTINCT li from  Lit li where li.actif=1 and li.estDisponible=1 and li.chambreId=:id ORDER BY li.numero")
    List<Lit> findAllByChambre(@Param("id") Long id);
}
