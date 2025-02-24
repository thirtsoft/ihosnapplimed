package com.iho.sn.admin.repository;

import com.iho.sn.admin.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query("Select DISTINCT u from Utilisateur u where u.est_valide=1 and u.id!=1 order by u.nom")
    List<Utilisateur> findAllActive();

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.id=:id")
    Utilisateur findUtilisateurById(@Param("id") Long id);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE (u.codeUtilisateur=:code or u.email=:code) and u.est_valide=1")
    Utilisateur findUserToConnect(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE (lower(u.codeUtilisateur)=lower(:code) or lower(u.email)=lower(:code)) and u.est_valide=1")
    Utilisateur findUserToConnectLow(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE lower(u.codeUtilisateur)=lower(:code) and u.est_valide=1")
    Utilisateur findByCodeUtilisateur(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE lower(u.email)=lower(:email) and u.est_valide=1")
    Utilisateur findByMail(@Param("email") String email);

    @Query("select case when count(u)> 0 then true else false end from Utilisateur u WHERE lower(u.codeUtilisateur)=lower(:code) and u.est_valide=1")
    boolean existeCodeUtilisateur(@Param("code") String code);

    @Query("select case when count(u)> 0 then true else false end from Utilisateur u WHERE lower(u.email)=lower(:email) and u.est_valide=1")
    boolean existeMail(@Param("email") String email);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE (u.codeUtilisateur=:code or u.email=:code) and u.est_valide=1")
    Optional<Utilisateur> findByCodeUtilisateurOrEmail(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE (lower(u.codeUtilisateur)=lower(:code) or lower(u.email)=lower(:code)) and u.est_valide=1")
    Optional<Utilisateur> findByCodeUtilisateurOrEmailLow(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u.email FROM Utilisateur u WHERE u.activation=:code")
    String findMailByActivation(@Param("code") String code);

    Optional<Utilisateur> findByEmail(String email);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.matricule=:matricule")
    Utilisateur findUtilisateurByMatricule(@Param("matricule") String matricule);

    @Query("Select DISTINCT u from Utilisateur u where u.actif=true and u.est_valide=1 and ((u.typeUtilisateur='Medecin') or (u.typeUtilisateur='Paramedical')) order by u.nom")
    List<Utilisateur> findAllMedecins();

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.codeUtilisateur=:code and u.est_valide=1")
    Optional<Utilisateur> findUtilisateurByCodeUtilisateur(@Param("code") String code);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.email=:email and u.est_valide=1")
    Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.telephone=:telephone and u.est_valide=1")
    Optional<Utilisateur> findUtilisateurByTelephone(@Param("telephone") String telephone);

    @Query(value = "SELECT DISTINCT u FROM Utilisateur u WHERE u.activation=:code")
    Utilisateur findUtilisateurByActivation(@Param("code") String code);
}