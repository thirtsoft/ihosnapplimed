package com.iho.sn.referentiel.remote.controller;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.dossiermedical.patient.entity.TrancheAge;
import com.iho.sn.referentiel.entity.TypeDocument;
import com.iho.sn.referentiel.remote.controller.api.ReferentielApi;
import com.iho.sn.referentiel.remote.model.CategoryMedicamentDs;
import com.iho.sn.referentiel.remote.model.ChambreDs;
import com.iho.sn.referentiel.remote.model.GroupeSanguinDs;
import com.iho.sn.referentiel.remote.model.LitDetailDs;
import com.iho.sn.referentiel.remote.model.LitDs;
import com.iho.sn.referentiel.remote.model.MedicamentDetailDs;
import com.iho.sn.referentiel.remote.model.MedicamentDs;
import com.iho.sn.referentiel.remote.model.ServicePartenaireDs;
import com.iho.sn.dossiermedical.patient.remote.model.TrancheAgeDs;
import com.iho.sn.referentiel.remote.model.TypeDocumentDs;
import com.iho.sn.referentiel.service.ReferentielService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReferentielController implements ReferentielApi {

    private final ReferentielService referentielService;

    private final ReferentielAssembler referentielAssembler;


    @Override
    public ResponseMassageDs creerCategoryMedicament(CategoryMedicamentDs categoryMedicamentDs) {
        CategoryMedicament categoryMedicament = referentielAssembler.assembleCategoryMedicamentFromDs(categoryMedicamentDs);
        try {
            Long id = referentielService.saveCategoryMedicament(categoryMedicament);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateCategoryMedicament(Long id, CategoryMedicamentDs categoryMedicamentDs) {
        CategoryMedicament categoryMedicament = referentielAssembler.assembleCategoryMedicamentFromDs(categoryMedicamentDs);
        try {
            Long updatedCategoryMedicament = referentielService.updateCategoryMedicament(id, categoryMedicament);
            return new ResponseMassageDs("OK", updatedCategoryMedicament.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<CategoryMedicamentDs> findCategoryMedicamentById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleCategoryMedicamentDsFromEntity(
                referentielService.findCategoryMedicamentById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryMedicamentDs>> findAllCategoriesMedicaments() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListCategoryMedicament(
                referentielService.findAllCategoryMedicaments()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteCategoryMedicament(Long id) {
        referentielService.deleteCategoryMedicament(id);
    }

    @Override
    public ResponseMassageDs creerMedicament(MedicamentDs medicamentDs) {
        Medicament medicament = referentielAssembler.assembleMedicamentfromDs(medicamentDs);
        try {
            Long id = referentielService.saveMedicament(medicament);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateMedicament(Long id, MedicamentDs medicamentDs) {
        Medicament medicament = referentielAssembler.assembleMedicamentfromDs(medicamentDs);
        try {
            Long updatedMedicament = referentielService.updateMedicament(id, medicament);
            return new ResponseMassageDs("OK", updatedMedicament.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<MedicamentDetailDs> findMedicamentById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleMedicamentDetailDsfromEntity(
                referentielService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MedicamentDetailDs>> findAllMedicaments() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListMedicament(
                referentielService.findAllMedicaments()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteMedicament(Long id) {
        referentielService.deleteMedicament(id);
    }

    @Override
    public ResponseMassageDs creerChambre(ChambreDs chambreDs) {
        Chambre chambre = referentielAssembler.assembleChambrefromDs(chambreDs);
        try {
            Long id = referentielService.saveChambre(chambre);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateChambre(Long id, ChambreDs chambreDs) {
        Chambre chambre = referentielAssembler.assembleChambrefromDs(chambreDs);
        try {
            Long updatedChambre = referentielService.updateChambre(id, chambre);
            return new ResponseMassageDs("OK", updatedChambre.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ChambreDs> findChambreById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleChambreDsfromEntity(
                referentielService.findChambreById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ChambreDs>> findAllChambres() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListChambre(
                referentielService.findAllChambres()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteChambre(Long id) {
        referentielService.deleteChambre(id);
    }

    @Override
    public ResponseMassageDs creerLit(LitDs litDs) {
        Lit lit = referentielAssembler.assembleLitfromDs(litDs);
        try {
            Long id = referentielService.saveLit(lit);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateLit(Long id, LitDs litDs) {
        Lit lit = referentielAssembler.assembleLitfromDs(litDs);
        try {
            Long updatedLit = referentielService.updateLit(id, lit);
            return new ResponseMassageDs("OK", updatedLit.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs changerEtatLitAOccupe(Long id, int etat) {
        try {
            referentielService.changerEtatLitAOccupe(id, etat);
            return new ResponseMassageDs("OK", "lit occupé");
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs amenerLitEnreparation(Long id, int etat) {
        try {
            referentielService.amenerLitEnreparation(id, etat);
            return new ResponseMassageDs("OK", "lit en répation");
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<LitDetailDs> findLitById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleLitDetailDsfromEntity(
                referentielService.findLitById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LitDetailDs>> findAllLits() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListLit(
                referentielService.findAllLits()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteLit(Long id) {
        referentielService.deleteLit(id);
    }

    @Override
    public ResponseEntity<List<LitDetailDs>> findAllLitByChambre(Long chambreId) {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListLit(
                referentielService.findAllByChambre(chambreId)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseMassageDs creerGroupeSanguin(GroupeSanguinDs groupeSanguinDs) {
        GroupeSanguin groupeSanguin = referentielAssembler.assembleGroupeSanguinfromDs(groupeSanguinDs);
        try {
            Long id = referentielService.saveGroupeSanguin(groupeSanguin);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateGroupeSanguin(Long id, GroupeSanguinDs groupeSanguinDs) {
        GroupeSanguin groupeSanguin = referentielAssembler.assembleGroupeSanguinfromDs(groupeSanguinDs);
        try {
            Long updatedGroupeSanguin = referentielService.updateGroupeSanguin(id, groupeSanguin);
            return new ResponseMassageDs("OK", updatedGroupeSanguin.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<GroupeSanguinDs> findGroupeSanguinById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleGroupeSanguinDsfromEntity(
                referentielService.findGroupeSanguinById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<GroupeSanguinDs>> findAllGroupeSanguins() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListGroupeSanguin(
                referentielService.findAllGroupeSanguins()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteGroupeSanguin(Long id) {
        referentielService.deleteGroupeSanguin(id);
    }

    @Override
    public ResponseMassageDs creerServicePartenaire(ServicePartenaireDs servicePartenaireDs) {
        ServicePartenaire servicePartenaire = referentielAssembler.assembleServicePartenairefromDs(servicePartenaireDs);
        try {
            Long id = referentielService.saveServicePartenaire(servicePartenaire);
            return new ResponseMassageDs("OK", id.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateServicePartenaire(Long id, ServicePartenaireDs servicePartenaireDs) {
        ServicePartenaire servicePartenaire = referentielAssembler.assembleServicePartenairefromDs(servicePartenaireDs);
        try {
            Long updatedSP = referentielService.updateServicePartenaire(id, servicePartenaire);
            return new ResponseMassageDs("OK", updatedSP.toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ServicePartenaireDs> findServicePartenaireById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleServicePartenaireDsfromEntity(
                referentielService.findServicePartenaireById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ServicePartenaireDs>> findAllServicePartenaires() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListServicePartenaire(
                referentielService.findAllServicePartenaires()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteServicePartenaire(Long id) {
        referentielService.deleteServicePartenaire(id);
    }

    @Override
    public ResponseMassageDs creerTypeDocument(TypeDocumentDs typeDocumentDs) {
        TypeDocument typeDocument = referentielAssembler.assembleTypeDocumentFromDs(typeDocumentDs);
        try {
            typeDocument = referentielService.saveTypeDocument(typeDocument);
            return new ResponseMassageDs("OK", typeDocument.getId().toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseMassageDs updateTypeDocument(Long id, TypeDocumentDs typeDocumentDs) throws Exception {
        TypeDocument typeDocument = referentielAssembler.assembleTypeDocumentFromDs(typeDocumentDs);
        try {
            typeDocument = referentielService.updateTypeDocument(id, typeDocument);
            return new ResponseMassageDs("OK", typeDocument.getId().toString());
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", e.getMessage());
        }
    }

    @Override
    public ResponseEntity<TypeDocumentDs> findById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleTypeDocumentFromEntity(
                referentielService.findTypeDocumentById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TypeDocumentDs>> findAllTypeDocuments() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListTypeDocument(
                referentielService.findAllTypeDocuments()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteTypeDocument(Long id) {
        referentielService.deleteTypeDocument(id);
    }
}
