package com.iho.sn.dossiermedical.rendezvous.service.Impl;


import com.iho.sn.dossiermedical.rendezvous.entity.RendezVous;
import com.iho.sn.dossiermedical.rendezvous.exception.RendezVousException;
import com.iho.sn.dossiermedical.rendezvous.repository.RendezVousRepository;
import com.iho.sn.dossiermedical.rendezvous.service.RendezVousService;
import com.iho.sn.message.Message;
import com.iho.sn.utils.ConstantSigps;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RendezVousServiceImpl implements RendezVousService {

    private final RendezVousRepository rendezVousRepository;

    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) throws RendezVousException {
        if (rendezVous == null)
            throw new RendezVousException(Message.NULL_OBJECT);
        if (rendezVous.getLibelle() == null || rendezVous.getLibelle().isEmpty())
            throw new RendezVousException("Le libellé du rendez vous est obligatoire");
        if (rendezVous.getPatientId() == null)
            throw new RendezVousException("Le choix d'un patient est obligatoire");
        if (rendezVous.getMedecinId() == null)
            throw new RendezVousException("Le choix du medecin est obligatoire");
        if (rendezVous.getHeure() == null || rendezVous.getHeure().isEmpty())
            throw new RendezVousException("L'heure du rendez vous est obligatoire");
        rendezVous.setActif(true);
        rendezVous.setCreateDate(new Date());
        rendezVous.setEtat(ConstantSigps.ETAT_PROGRAMME);
        rendezVousRepository.save(rendezVous);
        return rendezVous;
    }

    @Override
    public RendezVous updateRendezVous(Long id, RendezVous rendezVous) throws RendezVousException {
        if (!rendezVousRepository.existsById(id)) {
            throw new RendezVousException(Message.NOT_FOUND_OBJECT);
        }
        RendezVous founRendezVous = findById(id);
        if (founRendezVous == null)
            throw new RendezVousException(Message.NOT_FOUND_OBJECT);
        founRendezVous.setDateRendezVous(rendezVous.getDateRendezVous());
        founRendezVous.setHeure(rendezVous.getHeure());
        founRendezVous.setMedecinId(rendezVous.getMedecinId());
        return rendezVousRepository.save(founRendezVous);
    }

    @Override
    public RendezVous findById(Long id) {
        return rendezVousRepository.findRendezVousById(id);
    }

    @Override
    public List<RendezVous> findAllRendezVouss() {
        return rendezVousRepository.findAllRendezVous();
    }

    @Override
    public List<RendezVous> findAllRendezVousByDoctorId(Long matricule) {
        return rendezVousRepository.findRendezVousByDoctorMatricule(matricule);
    }

    @Override
    public List<RendezVous> findTreeLatestRendezVousByPatient(Long patientId) {
        return rendezVousRepository.findTreeLatestRendezVousByPatient(patientId);
    }

    @Override
    public List<RendezVous> findRendezVousDuJours() {
        return rendezVousRepository.findAllRendezVousDay();
    }

    @Override
    public List<RendezVous> findAllRendezVousOfDoctorInMonth(Long matricule) {
        return rendezVousRepository.findAllRendezVousOfDoctorInMonth(matricule);
    }

    @Override
    public void deplacezRendezVous(RendezVous rendezVousDeplace) throws RendezVousException {
        if (rendezVousDeplace == null) {
            throw new RendezVousException(Message.NOT_FOUND_OBJECT);
        }
        rendezVousRepository.save(rendezVousDeplace);
    }

    @Override
    public List<RendezVous> findRendezVousBySelectedDate(Date date) {
        return rendezVousRepository.findRendezVousBySelectedDate(date);
    }

    @Override
    public int countNumberOfRendezVousByDoctorAndDataRendezVous(Long matricule, Date date) {
        return rendezVousRepository.countNumberOfRendezVousByDoctorAndDataRendezVous(matricule, date);
    }

    @Override
    public List<RendezVous> findAllRendezVousByDay(Date date) {
        return rendezVousRepository.findAllByDateRendezVousAndActif(date, 1);
    }

    @Override
    public List<RendezVous> findAllActivesRendezVous() {
        return rendezVousRepository.findAllByActif(1);
    }

    @Override
    public void deleteRendezVous(Long id) {
        RendezVous deleted = rendezVousRepository.findRendezVousById(id);
        deleted.setActif(false);
        rendezVousRepository.save(deleted);
    }
}
