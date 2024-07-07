package com.iho.sn.dossiermedical.patient.repository;

import com.iho.sn.dossiermedical.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepositry extends JpaRepository<Patient, Long> {

    @Query("SELECT DISTINCT p from Patient p where p.id=:id and p.actif=1")
    Patient findPatientById(@Param("id") Long id);

    @Query("SELECT DISTINCT p from Patient p where p.code=:code and p.actif=1")
    Patient findPatientByCode(@Param("code") String code);

    @Query("SELECT DISTINCT p from Patient p where p.actif=1 ORDER BY p.id DESC")
    List<Patient> findAllPatients();

    @Query("SELECT COUNT(p) from Patient p where p.actif=1")
    long countActivePatient();

    @Query("SELECT DISTINCT p from Patient p where p.actif=1 ORDER BY p.prenom DESC")
    List<Patient> findAllPatientOrderByFirstName();

    @Query("SELECT p FROM Patient p WHERE lower(p.code) = lower(:code) AND p.actif = 1")
    Optional<Patient> findByCode(@Param("code") String code);

    @Query("SELECT p FROM Patient p WHERE lower(p.numeroTelephone) = lower(:telephone) AND p.actif = 1")
    Optional<Patient> findByNumeroTelephone(@Param("telephone") String telephone);
}
