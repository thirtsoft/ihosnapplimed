package com.iho.sn.dossiermedical.consultation.repository;

import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultationMedicalRepository extends JpaRepository<ConsultationMedical, Long>, JpaSpecificationExecutor<ConsultationMedical> {

    @Query("SELECT DISTINCT cons from ConsultationMedical cons where cons.id=:id and cons.actif=1")
    Optional<ConsultationMedical> findConsultationMedicalById(@Param("id") Long id);

    @Query("SELECT DISTINCT cons from ConsultationMedical cons where cons.actif=1")
    List<ConsultationMedical> findAllConsultationMedicals();

    @Query("SELECT DISTINCT cons from ConsultationMedical cons where cons.code=:code and cons.actif=1 ORDER BY cons.id DESC LIMIT 3")
    List<ConsultationMedical> findAllByPatient(@Param("code") String code);

    @Query("SELECT DISTINCT max(act.numeroConsultation) FROM ConsultationMedical act")
    int maxNumeroConsultationMedical();

    @Query("SELECT COUNT(cons) FROM ConsultationMedical cons WHERE cons.typePatient=1")
    int countConsultationMedicalHomme();

    @Query("SELECT COUNT(cons) FROM ConsultationMedical cons WHERE cons.typePatient=0")
    int countConsultationMedicalFemme();

    @Query("SELECT COUNT(cons) FROM ConsultationMedical cons")
    long countConsultationMedical();
}
