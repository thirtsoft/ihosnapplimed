package com.iho.sn.admin.remote.controller;

import com.iho.sn.admin.assembler.ActionAssembler;
import com.iho.sn.admin.entities.Action;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.controller.api.ActionApi;
import com.iho.sn.admin.remote.model.ActionListDs;
import com.iho.sn.admin.service.ActionService;
import com.iho.sn.admin.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
public class ActionController implements ActionApi {

    private final ActionService actionService;
    private final UtilisateurService utilisateurService;
    private final ActionAssembler actionAssembler;

    @Override
    public void creerAction(ActionListDs actionListDs) {
        actionService.saveAction(actionAssembler.assembleActionFromDs(actionListDs));
    }

    @Override
    public void updateAction(Long id, ActionListDs actionListDs) {
        Action action = actionAssembler.assembleActionFromDs(actionListDs);
        actionService.updateAction(id, action);
    }

    @Override
    public ResponseEntity<ActionListDs> findById(Long id) {
        return new ResponseEntity<>(actionAssembler.assembleEntityToDs(actionService.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActionListDs> findByCode(String code) {
        return new ResponseEntity<>(actionAssembler.assembleEntityToDs(actionService.findByCode(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActionListDs> findByLibelle(String libelle) {
        return new ResponseEntity<>(actionAssembler.assembleEntityToDs(actionService.findByLibelle(libelle)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActionListDs> findByTypeProfil(Long typeProfil) {
        return null;
    }

    @Override
    public ResponseEntity<ActionListDs> findByLibelleAndProfil(String libelle, Long typeProfil) {
        return new ResponseEntity<>(actionAssembler.assembleEntityToDs(actionService.findByLibelle(libelle, typeProfil)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ActionListDs>> findAllActions() {
        return new ResponseEntity<>(actionAssembler.assembleEntitiesFrom(
                actionService.findAll()
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ActionListDs>> findAllActionsByTypeProfil(Long typeProfil) {
        return new ResponseEntity<>(actionAssembler.assembleEntitiesFrom(
                actionService.findByTypeProfil(typeProfil)
        ), HttpStatus.OK);
    }

    @Override
    public void deleteAction(Long id) {
        actionService.deleteAction(id);
    }

    @Override
    public ResponseEntity<List<ActionListDs>> canDo(Long userId) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(userId);
        return new ResponseEntity<>(actionAssembler.assembleEntitiesFrom(
                actionService.getListActionByProfil(utilisateur.getProfil().getCode())
        ), HttpStatus.OK);
    }
}
