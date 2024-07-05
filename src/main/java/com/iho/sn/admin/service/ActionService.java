package com.iho.sn.admin.service;

import com.iho.sn.admin.entities.Action;

import java.util.List;

public interface ActionService {

    void saveAction(Action action);

    void updateAction(Long id, Action action);

    Action findById(Long id);

    List<Action> findAll();

    Action findByCode(String code);

    Action findByLibelle(String libelle, Long typeProfil);

    Action findByLibelle(String libelle);

    List<Action> findByTypeProfil(Long typeProfil);

    void deleteAction(Long id);

    List<Action> getListActionByProfil(String codeProfil);
}
