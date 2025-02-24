package com.iho.sn.admin.service.impl;


import com.iho.sn.admin.entities.Action;
import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.repository.ActionRepository;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.service.ActionService;
import com.iho.sn.exception.ActionNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    private final ProfilRepository profilRepository;

    @Override
    public void saveAction(Action action) {
        String code = action.getCode();
        Optional<Action> byCode = actionRepository.findByActionCode(code);
        if (action.getId() == null && byCode.isPresent()
                || (action.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(action.getId()))) {
            throw new ActionNotFoundException(String.format("Le code %s est déjà associé à pour une autre action .", code));
        }
        actionRepository.save(action);
    }

    @Override
    public void updateAction(Long id, Action action) {
        actionRepository.findById(id)
                .ifPresent(ac -> {
                    ac.setCode(action.getCode());
                    ac.setLibelle(action.getLibelle());
                });
    }

    @Override
    public Action findById(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    @Override
    public Action findByCode(String code) {
        return actionRepository.findByCode(code);
    }

    @Override
    public Action findByLibelle(String libelle, Long typeProfil) {
        return actionRepository.findByLibelle(libelle);
    }

    @Override
    public Action findByLibelle(String libelle) {
        return actionRepository.findByLibelle(libelle);
    }

    @Override
    public List<Action> findByTypeProfil(Long typeProfil) {
        return emptyList();
    }

    @Override
    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }

    @Override
    public List<Action> getListActionByProfil(String codeProfil) {
        Profil profil = profilRepository.findByCodeFromAction(codeProfil);
        return new ArrayList<>(profil.getAction());
    }

}