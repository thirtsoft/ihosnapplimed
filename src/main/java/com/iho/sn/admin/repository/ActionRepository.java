package com.iho.sn.admin.repository;

import com.iho.sn.admin.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    @Query("Select DISTINCT act from  Action act where act.code=:code")
    Action findByCode(@Param("code") String code);

    @Query("Select DISTINCT act from  Action act where act.libelle=:libelle")
    Action findByLibelle(@Param("libelle") String libelle);

    @Query("SELECT act FROM Action act WHERE lower(act.code) = lower(:code)")
    Optional<Action> findByActionCode(@Param("code") String code);
}
