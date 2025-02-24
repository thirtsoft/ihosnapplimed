package com.iho.sn.admin.assembler;

import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.remote.model.ProfilDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfilAssembler {

    private final ActionAssembler actionAssembler;

    public ProfilAssembler(ActionAssembler actionAssembler) {
        this.actionAssembler = actionAssembler;
    }

    public List<ProfilDs> assembleEntitiesFrom(List<Profil> profils) {
        return profils.stream().map(this::assembleEntityToDs).toList();
    }

    public ProfilDs assembleEntityToDs(Profil profil) {
        ProfilDs profilDs = new ProfilDs();
        profilDs.setId(profil.getId());
        profilDs.setCode(profil.getCode());
        profilDs.setLibelle(profil.getLibelle());
        profilDs.setActif(profil.isActif());
        profilDs.setActionListDs(actionAssembler.createListActionListDs(profil.getAction()));
        return profilDs;
    }

    public Profil assembleProfilFromDs(ProfilDs profilDs) {
        Profil profil = new Profil();
        if (profilDs == null)
            return null;
        profil.setId(profilDs.getId());
        profil.setCode(profilDs.getCode());
        profil.setLibelle(profilDs.getLibelle());
        profil.setActif(profilDs.isActif());
        profil.setAction(actionAssembler.createSetAction(profilDs.getActionListDs()));
        return profil;
    }

}
