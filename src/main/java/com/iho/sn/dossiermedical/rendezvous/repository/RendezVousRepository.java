package com.iho.sn.dossiermedical.rendezvous.repository;

import com.iho.sn.dossiermedical.rendezvous.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    @Query("SELECT DISTINCT rv from RendezVous rv where rv.id=:id and rv.actif=1")
    RendezVous findRendezVousById(@Param("id") Long id);

    @Query("SELECT DISTINCT rv from RendezVous rv where rv.actif=1 order by rv.id desc")
    List<RendezVous> findAllRendezVous();
    @Query("SELECT rv from RendezVous rv where rv.actif=1 and rv.medecinId=:matricule Order by rv.dateRendezVous DESC")
    List<RendezVous> findRendezVousByDoctorMatricule(@Param("matricule") Long matricule);

    @Query("SELECT DISTINCT rv from RendezVous rv where rv.patientId=:patient and rv.actif=1 ORDER BY rv.id DESC LIMIT 3")
    List<RendezVous> findTreeLatestRendezVousByPatient(@Param("patient") Long code);

    @Query("SELECT DISTINCT rv FROM RendezVous rv WHERE rv.dateRendezVous=current_date and rv.actif=1 ORDER BY rv.id")
    List<RendezVous> findAllRendezVousDay();

    List<RendezVous> findAllByDateRendezVousAndActif(Date dateRendezVous, int actif);

    @Query("SELECT DISTINCT rv FROM RendezVous rv WHERE rv.medecinId=:matricule and month(rv.dateRendezVous)=month(current_date) and rv.actif=1 ORDER BY rv.id")
    List<RendezVous> findAllRendezVousOfDoctorInMonth(@Param("matricule") Long matricule);

    @Query("SELECT DISTINCT rv from RendezVous rv where rv.actif=1 and rv.dateRendezVous=:date Order by rv.dateRendezVous DESC")
    List<RendezVous> findRendezVousBySelectedDate(@Param("date") Date date);

    @Query("select count(rv) from RendezVous rv where rv.medecinId=:matricule and rv.dateRendezVous=:date and rv.actif=1 ")
    int countNumberOfRendezVousByDoctorAndDataRendezVous(@Param("matricule") Long matricule, @Param("date") Date date);

    List<RendezVous> findAllByActif(int actif);

    @Query("SELECT DISTINCT rv from RendezVous rv where rv.patientId=:patient and rv.actif=1")
    List<RendezVous> findListetRendezVousByPatient(@Param("patient") Long code);

}
