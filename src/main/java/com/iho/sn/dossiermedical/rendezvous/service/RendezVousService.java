package com.iho.sn.dossiermedical.rendezvous.service;

import com.iho.sn.dossiermedical.rendezvous.entity.RendezVous;
import com.iho.sn.dossiermedical.rendezvous.exception.RendezVousException;

import java.util.Date;
import java.util.List;

public interface RendezVousService {

    RendezVous saveRendezVous(RendezVous rendezVous) throws RendezVousException;

    RendezVous updateRendezVous(Long id, RendezVous rendezVous) throws RendezVousException;

    RendezVous findById(Long id);

    List<RendezVous> findAllRendezVouss();

    List<RendezVous> findAllRendezVousByDoctorId(Long matricule);

    List<RendezVous> findTreeLatestRendezVousByPatient(Long patientId);

    List<RendezVous> findRendezVousDuJours();

    List<RendezVous> findAllRendezVousOfDoctorInMonth(Long matricule);

    void deplacezRendezVous(RendezVous rendezVousDeplace) throws RendezVousException;

    List<RendezVous> findRendezVousBySelectedDate(Date date);

    int countNumberOfRendezVousByDoctorAndDataRendezVous(Long matricule, Date date);

    List<RendezVous> findAllRendezVousByDay(Date date);

    List<RendezVous> findAllActivesRendezVous();

    void deleteRendezVous(Long id);

}
