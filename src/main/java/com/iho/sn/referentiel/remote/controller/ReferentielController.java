package com.iho.sn.referentiel.remote.controller;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.message.Message;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.DermatoseAutoimine;
import com.iho.sn.referentiel.entity.DermatoseBulleuse;
import com.iho.sn.referentiel.entity.DermatoseInfBacterienne;
import com.iho.sn.referentiel.entity.DermatoseInfVirale;
import com.iho.sn.referentiel.entity.DermatoseInfectieuse;
import com.iho.sn.referentiel.entity.DermatoseInflammatoire;
import com.iho.sn.referentiel.entity.ElementExamenDermatologique;
import com.iho.sn.referentiel.entity.ElementHypothese;
import com.iho.sn.referentiel.entity.ElementPlainte;
import com.iho.sn.referentiel.entity.ElementRechercheNotion;
import com.iho.sn.referentiel.entity.ElementTerrain;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.referentiel.entity.TypeDocument;
import com.iho.sn.referentiel.remote.controller.api.ReferentielApi;
import com.iho.sn.referentiel.remote.model.CategoryMedicamentDs;
import com.iho.sn.referentiel.remote.model.ChambreDs;
import com.iho.sn.referentiel.remote.model.DermatoseAutoimineDs;
import com.iho.sn.referentiel.remote.model.DermatoseBulleuseDs;
import com.iho.sn.referentiel.remote.model.DermatoseInfBacterienneDs;
import com.iho.sn.referentiel.remote.model.DermatoseInfViraleDs;
import com.iho.sn.referentiel.remote.model.DermatoseInfectieuseDs;
import com.iho.sn.referentiel.remote.model.DermatoseInflammatoireDs;
import com.iho.sn.referentiel.remote.model.ElementExamenDermatologiqueDs;
import com.iho.sn.referentiel.remote.model.ElementHypotheseDs;
import com.iho.sn.referentiel.remote.model.ElementPlainteDs;
import com.iho.sn.referentiel.remote.model.ElementRechercheNotionDs;
import com.iho.sn.referentiel.remote.model.ElementTerrainDs;
import com.iho.sn.referentiel.remote.model.GroupeSanguinDs;
import com.iho.sn.referentiel.remote.model.LitDetailDs;
import com.iho.sn.referentiel.remote.model.LitDs;
import com.iho.sn.referentiel.remote.model.MedicamentDetailDs;
import com.iho.sn.referentiel.remote.model.MedicamentDs;
import com.iho.sn.referentiel.remote.model.ServicePartenaireDs;
import com.iho.sn.referentiel.remote.model.TypeDocumentDs;
import com.iho.sn.referentiel.service.ElementConsultationService;
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

    private final ElementConsultationService elementConsultationService;

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

    @Override
    public ResponseMassageDs creerDermatoseAutoimine(DermatoseAutoimineDs dermatoseAutoimineDs) {
        DermatoseAutoimine dermatoseAutoimine = referentielAssembler.assembleDermatoseAutoimineFromDs(dermatoseAutoimineDs);
        try {
            elementConsultationService.saveDermatoseAutoimine(dermatoseAutoimine);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseAutoimine(Long id, DermatoseAutoimineDs dermatoseAutoimineDs) {
        DermatoseAutoimine dermatoseAutoimine = referentielAssembler.assembleDermatoseAutoimineFromDs(dermatoseAutoimineDs);
        try {
            elementConsultationService.updateDermatoseAutoimine(id, dermatoseAutoimine);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseAutoimineDs> findDermatoseAutoimineById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseAutoimineDsFromEntity(
                elementConsultationService.findDermatoseAutoimineById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseAutoimineDs>> findAllDermatoseAutoimines() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseAutoimine(
                elementConsultationService.findAllDermatoseAutoimines()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseAutoimine(Long id) {
        elementConsultationService.deleteDermatoseAutoimine(id);
    }

    @Override
    public ResponseMassageDs creerDermatoseBulleuse(DermatoseBulleuseDs dermatoseBulleuseDs) {
        DermatoseBulleuse dermatoseBulleuse = referentielAssembler.assembleDermatoseBulleuseFromDs(dermatoseBulleuseDs);
        try {
            elementConsultationService.saveDermatoseBulleuse(dermatoseBulleuse);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseBulleuse(Long id, DermatoseBulleuseDs dermatoseBulleuseDs) {
        DermatoseBulleuse dermatoseBulleuse = referentielAssembler.assembleDermatoseBulleuseFromDs(dermatoseBulleuseDs);
        try {
            elementConsultationService.updateDermatoseBulleuse(id, dermatoseBulleuse);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseBulleuseDs> findDermatoseBulleuseById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseBulleuseDsFromEntity(
                elementConsultationService.findDermatoseBulleuseById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseBulleuseDs>> findAllDermatoseBulleuses() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseBulleuse(
                elementConsultationService.findAllDermatoseBulleuses()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseBulleuse(Long id) {
        elementConsultationService.deleteDermatoseBulleuse(id);
    }

    @Override
    public ResponseMassageDs creerDermatoseInfBacterienne(DermatoseInfBacterienneDs dermatoseInfBacterienneDs) {
        DermatoseInfBacterienne dermatoseInfBacterienne = referentielAssembler.assembleDermatoseInfBacterienneFromDs(dermatoseInfBacterienneDs);
        try {
            elementConsultationService.saveDermatoseInfBacterienne(dermatoseInfBacterienne);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseInfBacterienne(Long id, DermatoseInfBacterienneDs dermatoseInfBacterienneDs) {
        DermatoseInfBacterienne dermatoseInfBacterienne = referentielAssembler.assembleDermatoseInfBacterienneFromDs(dermatoseInfBacterienneDs);
        try {
            elementConsultationService.updateDermatoseInfBacterienne(id, dermatoseInfBacterienne);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseInfBacterienneDs> findDermatoseInfBacterienneById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseInfBacterienneDsFromEntity(
                elementConsultationService.findDermatoseInfBacterienneById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseInfBacterienneDs>> findAllDermatoseInfBacteriennes() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseInfBacterienne(
                elementConsultationService.findAllDermatoseInfBacteriennes()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseInfBacterienne(Long id) {

    }

    @Override
    public ResponseMassageDs creerDermatoseInfectieuse(DermatoseInfectieuseDs dermatoseInfectieuseDs) {
        DermatoseInfectieuse dermatoseInfectieuse = referentielAssembler.assembleDermatoseInfectieuseFromDs(dermatoseInfectieuseDs);
        try {
            elementConsultationService.saveDermatoseInfectieuse(dermatoseInfectieuse);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseInfectieuse(Long id, DermatoseInfectieuseDs dermatoseInfectieuseDs) {
        DermatoseInfectieuse dermatoseInfectieuse = referentielAssembler.assembleDermatoseInfectieuseFromDs(dermatoseInfectieuseDs);
        try {
            elementConsultationService.updateDermatoseInfectieuse(id, dermatoseInfectieuse);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseInfectieuseDs> findDermatoseInfectieuseById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseInfectieuseDsFromEntity(
                elementConsultationService.findDermatoseInfectieuseById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseInfectieuseDs>> findAllDermatoseInfectieuses() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseInfectieuse(
                elementConsultationService.findAllDermatoseInfectieuses()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseInfectieuse(Long id) {
        elementConsultationService.deleteDermatoseInfectieuse(id);
    }

    @Override
    public ResponseMassageDs creerDermatoseInflammatoire(DermatoseInflammatoireDs dermatoseInflammatoireDs) {
        DermatoseInflammatoire dermatoseInflammatoire = referentielAssembler.assembleDermatoseInflammatoireFromDs(dermatoseInflammatoireDs);
        try {
            elementConsultationService.saveDermatoseInflammatoire(dermatoseInflammatoire);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseInflammatoire(Long id, DermatoseInflammatoireDs dermatoseInflammatoireDs) {
        DermatoseInflammatoire dermatoseInflammatoire = referentielAssembler.assembleDermatoseInflammatoireFromDs(dermatoseInflammatoireDs);
        try {
            elementConsultationService.updateDermatoseInflammatoire(id, dermatoseInflammatoire);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseInflammatoireDs> findDermatoseInflammatoireById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseInflammatoireDsFromEntity(
                elementConsultationService.findDermatoseInflammatoireById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseInflammatoireDs>> findAllDermatoseInflammatoires() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseInflammatoire(
                elementConsultationService.findAllDermatoseInflammatoires()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseInflammatoire(Long id) {
        elementConsultationService.deleteDermatoseInflammatoire(id);
    }

    @Override
    public ResponseMassageDs creerDermatoseInfVirale(DermatoseInfViraleDs dermatoseInfViraleDs) {
        DermatoseInfVirale dermatoseInfVirale = referentielAssembler.assembleDermatoseInfViraleDs(dermatoseInfViraleDs);
        try {
            elementConsultationService.saveDermatoseInfVirale(dermatoseInfVirale);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateDermatoseInfVirale(Long id, DermatoseInfViraleDs dermatoseInfViraleDs) {
        DermatoseInfVirale dermatoseInfVirale = referentielAssembler.assembleDermatoseInfViraleDs(dermatoseInfViraleDs);
        try {
            elementConsultationService.updateDermatoseInfVirale(id, dermatoseInfVirale);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<DermatoseInfViraleDs> findDermatoseInfViraleById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleDermatoseInfViraleDsFromEntity(
                elementConsultationService.findDermatoseInfViraleById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DermatoseInfViraleDs>> findAllDermatoseInfVirales() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListDermatoseInfVirale(
                elementConsultationService.findAllDermatoseInfVirales()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDermatoseInfVirale(Long id) {
        elementConsultationService.deleteDermatoseInfVirale(id);
    }

    @Override
    public ResponseMassageDs creerElementExamenDermatologique(ElementExamenDermatologiqueDs elementExamenDermatologiqueDs) {
        ElementExamenDermatologique elementExamenDermatologique = referentielAssembler.assembleElementExamenDermatologiqueFromDs(elementExamenDermatologiqueDs);
        try {
            elementConsultationService.saveElementExamenDermatologique(elementExamenDermatologique);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateElementExamenDermatologique(Long id, ElementExamenDermatologiqueDs elementExamenDermatologiqueDs) {
        ElementExamenDermatologique elementExamenDermatologique = referentielAssembler.assembleElementExamenDermatologiqueFromDs(elementExamenDermatologiqueDs);
        try {
            elementConsultationService.updateElementExamenDermatologique(id, elementExamenDermatologique);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<ElementExamenDermatologiqueDs> findElementExamenDermatologiqueById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleElementExamenDermatologiqueDsFromEntity(
                elementConsultationService.findElementExamenDermatologiqueById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ElementExamenDermatologiqueDs>> findAllElementExamenDermatologiques() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListElementExamenDermatologique(
                elementConsultationService.findAllElementExamenDermatologiques()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteElementExamenDermatologique(Long id) {
        elementConsultationService.deleteElementExamenDermatologique(id);
    }

    @Override
    public ResponseMassageDs creerElementHypothese(ElementHypotheseDs elementHypotheseDs) {
        ElementHypothese elementHypothese = referentielAssembler.assembleElementHypotheseFromDs(elementHypotheseDs);
        try {
            elementConsultationService.saveElementHypothese(elementHypothese);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateElementHypothese(Long id, ElementHypotheseDs elementHypotheseDs) {
        ElementHypothese elementHypothese = referentielAssembler.assembleElementHypotheseFromDs(elementHypotheseDs);
        try {
            elementConsultationService.updateElementHypothese(id, elementHypothese);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<ElementHypotheseDs> findElementHypotheseById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleElementElementHypotheseDsFromEntity(
                elementConsultationService.findElementHypotheseById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ElementHypotheseDs>> findAllElementHypotheses() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListElementHypothese(
                elementConsultationService.findAllElementHypotheses()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteElementHypothese(Long id) {
        elementConsultationService.deleteElementHypothese(id);
    }

    @Override
    public ResponseMassageDs creerElementPlainte(ElementPlainteDs elementPlainteDs) {
        ElementPlainte elementPlainte = referentielAssembler.assembleElementPlainteFromDs(elementPlainteDs);
        try {
            elementConsultationService.saveElementPlainte(elementPlainte);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateElementPlainte(Long id, ElementPlainteDs elementPlainteDs) {
        ElementPlainte elementPlainte = referentielAssembler.assembleElementPlainteFromDs(elementPlainteDs);
        try {
            elementConsultationService.updateElementPlainte(id, elementPlainte);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<ElementPlainteDs> findElementPlainteById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleElementPlainteDsFromEntity(
                elementConsultationService.findElementPlainteById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ElementPlainteDs>> findAllElementPlaintes() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromLisElementPlainte(
                elementConsultationService.findAllElementPlaintes()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteElementPlainte(Long id) {
        elementConsultationService.deleteElementPlainte(id);
    }

    @Override
    public ResponseMassageDs creerElementRechercheNotion(ElementRechercheNotionDs elementRechercheNotionDs) {
        ElementRechercheNotion elementRechercheNotion = referentielAssembler.assembleElementRechercheNotionFromDs(elementRechercheNotionDs);
        try {
            elementConsultationService.saveElementRechercheNotion(elementRechercheNotion);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateElementRechercheNotion(Long id, ElementRechercheNotionDs elementRechercheNotionDs) {
        ElementRechercheNotion elementRechercheNotion = referentielAssembler.assembleElementRechercheNotionFromDs(elementRechercheNotionDs);
        try {
            elementConsultationService.updateElementRechercheNotion(id, elementRechercheNotion);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<ElementRechercheNotionDs> findElementRechercheNotionById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleElementRechercheNotionDsFromEntity(
                elementConsultationService.findElementRechercheNotionById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ElementRechercheNotionDs>> findAllElementRechercheNotions() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListElementRechercheNotion(
                elementConsultationService.findAllElementRechercheNotions()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteElementRechercheNotion(Long id) {
        elementConsultationService.deleteElementRechercheNotion(id);
    }

    @Override
    public ResponseMassageDs creerElementTerrain(ElementTerrainDs elementTerrainDs) {
        ElementTerrain elementTerrain = referentielAssembler.assembleElementTerrainFromDs(elementTerrainDs);
        try {
            elementConsultationService.saveElementTerrain(elementTerrain);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseMassageDs updateElementTerrain(Long id, ElementTerrainDs elementTerrainDs) {
        ElementTerrain elementTerrain = referentielAssembler.assembleElementTerrainFromDs(elementTerrainDs);
        try {
            elementConsultationService.updateElementTerrain(id, elementTerrain);
            return new ResponseMassageDs("OK", Message.SUCCESS_MESSAGE);
        } catch (Exception e) {
            return new ResponseMassageDs("FAILED", Message.FAILED_MESSAGE);
        }
    }

    @Override
    public ResponseEntity<ElementTerrainDs> findElementTerrainById(Long id) {
        return new ResponseEntity<>(referentielAssembler.assembleElementTerrainDsFromEntity(
                elementConsultationService.findElementTerrainById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ElementTerrainDs>> findAllElementTerrains() {
        return new ResponseEntity<>(referentielAssembler.assembleEntitiesFromListElementTerrain(
                elementConsultationService.findAllElementTerrains()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteElementTerrain(Long id) {
        elementConsultationService.deleteElementTerrain(id);
    }
}
