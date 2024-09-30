package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.BilanParaclinique;
import com.iho.sn.dossiermedical.consultation.remote.model.BilanParacliniqueDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BilanParacliniqueAssembler {

    public List<BilanParacliniqueDs> assembleEntitiesFrom(List<BilanParaclinique> bilanParacliniques) {
        return bilanParacliniques.stream().map(this::assembleFromEntityToDs).toList();
    }

    public BilanParacliniqueDs assembleFromEntityToDs(BilanParaclinique bilanParaclinique) {
        BilanParacliniqueDs bilanParacliniqueDs = new BilanParacliniqueDs();
        bilanParacliniqueDs.setBiologie(bilanParaclinique.getBiologie());
        bilanParacliniqueDs.setBiochimie(bilanParaclinique.getBiochimie());
        return bilanParacliniqueDs;
    }

    public BilanParaclinique assembleAntecedentFromDs(BilanParacliniqueDs bilanParacliniqueDs) {
        BilanParaclinique bilanParaclinique = new BilanParaclinique();
        bilanParaclinique.setBiologie(bilanParacliniqueDs.getBiologie());
        bilanParaclinique.setBiochimie(bilanParacliniqueDs.getBiochimie());
        return bilanParaclinique;
    }

    public BilanParaclinique assembleUpdateBilanParacliniqueFromDs(BilanParaclinique bilanParaclinique, BilanParacliniqueDs bilanParacliniqueDs) {
        bilanParaclinique.setBiologie(bilanParacliniqueDs.getBiologie());
        bilanParaclinique.setBiochimie(bilanParacliniqueDs.getBiochimie());
        return bilanParaclinique;
    }
}
