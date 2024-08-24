package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import com.iho.sn.enumeration.StatusHospitalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long>, JpaSpecificationExecutor<Hospitalisation> {

    @Query("SELECT DISTINCT hos from Hospitalisation hos where hos.id=:id")
    Optional<Hospitalisation> findHospitalisationById(@Param("id") Long id);

    @Query("SELECT DISTINCT hos from Hospitalisation hos")
    List<Hospitalisation> findAllHospitalisations();

    @Query("SELECT DISTINCT hos from Hospitalisation hos where hos.code=:code ORDER BY hos.id DESC LIMIT 3")
    List<Hospitalisation> findAllByPatient(@Param("code") String code);

    @Query("SELECT DISTINCT max(act.numeroHospitalisation) FROM Hospitalisation act")
    int maxNumeroHospitalisation();

    @Query("SELECT COUNT(hos) FROM Hospitalisation hos WHERE hos.typePatient=1")
    int countHospitalisationHomme();

    @Query("SELECT COUNT(hos) FROM Hospitalisation hos WHERE hos.typePatient=0")
    int countHospitalisationFemme();

    @Query("SELECT COUNT(hos) FROM Hospitalisation hos")
    long countHospitalisation();

    List<Hospitalisation> findByStatusHospitalisation(StatusHospitalisation statusHospitalisation);
}