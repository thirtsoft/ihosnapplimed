package com.iho.sn.referentiel.remote.controller.api;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.remote.model.CategoryMedicamentDs;
import com.iho.sn.referentiel.remote.model.ChambreDs;
import com.iho.sn.referentiel.remote.model.GroupeSanguinDs;
import com.iho.sn.referentiel.remote.model.LitDetailDs;
import com.iho.sn.referentiel.remote.model.LitDs;
import com.iho.sn.referentiel.remote.model.MedicamentDetailDs;
import com.iho.sn.referentiel.remote.model.MedicamentDs;
import com.iho.sn.referentiel.remote.model.ServicePartenaireDs;
import com.iho.sn.referentiel.remote.model.TrancheAgeDs;
import com.iho.sn.referentiel.remote.model.TypeDocumentDs;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.iho.sn.utils.ApiUrlAccess.APP_ROOT;

@RequestMapping(value = "/referentiel")
public interface ReferentielApi {

    @PostMapping(value = "/categorymedicament/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerCategoryMedicament(@RequestBody CategoryMedicamentDs categoryMedicamentDs);

    @PutMapping(value = "/categorymedicament/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateCategoryMedicament(@PathVariable Long id, @RequestBody CategoryMedicamentDs categoryMedicamentDs);

    @GetMapping(value = "/categorymedicament/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryMedicamentDs> findCategoryMedicamentById(@PathVariable Long id);

    @GetMapping(value = "/categorymedicament/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryMedicamentDs>> findAllCategoriesMedicaments();

    @DeleteMapping(value = "/categorymedicament/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteCategoryMedicament(@PathVariable Long id);

    /************************ Medicament ***************************/

    @PostMapping(value = "/medicament/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerMedicament(@RequestBody MedicamentDs medicamentDs);

    @PutMapping(value = "/medicament/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateMedicament(@PathVariable Long id, @RequestBody MedicamentDs medicamentDs);

    @GetMapping(value = "/medicament/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MedicamentDetailDs> findMedicamentById(@PathVariable Long id);

    @GetMapping(value = "/medicament/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MedicamentDetailDs>> findAllMedicaments();

    @DeleteMapping(value = "/medicament/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteMedicament(@PathVariable Long id);

    /************************ Chambre ***************************/

    @PostMapping(value = "/chambre/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerChambre(@RequestBody ChambreDs chambreDs);

    @PutMapping(value = "/chambre/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateChambre(@PathVariable Long id, @RequestBody ChambreDs chambreDs);

    @GetMapping(value = "/chambre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ChambreDs> findChambreById(@PathVariable Long id);

    @GetMapping(value = "/chambre/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ChambreDs>> findAllChambres();

    @DeleteMapping(value = "/chambre/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteChambre(@PathVariable Long id);

    /************************ Lit ***************************/

    @PostMapping(value = "/lit/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerLit(@RequestBody LitDs litDs);

    @PutMapping(value = "/lit/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateLit(@PathVariable Long id, @RequestBody LitDs litDs);

    @PutMapping(value = "/lit/occuper/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs changerEtatLitAOccupe(@PathVariable Long id, @RequestParam int etat);

    @PutMapping(value = "/lit/enreparation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs amenerLitEnreparation(@PathVariable Long id, @RequestParam int etat);

    @GetMapping(value = "/lit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<LitDetailDs> findLitById(@PathVariable Long id);

    @GetMapping(value = "/lit/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LitDetailDs>> findAllLits();

    @DeleteMapping(value = "/lit/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteLit(@PathVariable Long id);

    @GetMapping(value = "/lit/by-chambre/{chambreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<LitDetailDs>> findAllLitByChambre(@PathVariable Long chambreId);


    /************************ GroupeSanguin ***************************/
    @PostMapping(value = "/groupesanguin/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerGroupeSanguin(@RequestBody GroupeSanguinDs groupeSanguinDs);

    @PutMapping(value = "/groupesanguin/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateGroupeSanguin(@PathVariable Long id, @RequestBody GroupeSanguinDs groupeSanguinDs);

    @GetMapping(value = "/groupesanguin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GroupeSanguinDs> findGroupeSanguinById(@PathVariable Long id);

    @GetMapping(value = "/groupesanguin/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<GroupeSanguinDs>> findAllGroupeSanguins();

    @DeleteMapping(value = "/groupesanguin/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteGroupeSanguin(@PathVariable Long id);

    /************************ ServicePartenaire ***************************/
    @PostMapping(value = "/servicepartenaire/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerServicePartenaire(@RequestBody ServicePartenaireDs servicePartenaireDs);

    @PutMapping(value = "/servicepartenaire/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateServicePartenaire(@PathVariable Long id, @RequestBody ServicePartenaireDs servicePartenaireDs);

    @GetMapping(value = "/servicepartenaire/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ServicePartenaireDs> findServicePartenaireById(@PathVariable Long id);

    @GetMapping(value = "/servicepartenaire/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ServicePartenaireDs>> findAllServicePartenaires();

    @DeleteMapping(value = "/servicepartenaire/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteServicePartenaire(@PathVariable Long id);

    /************************ TrancheAge ***************************/
    @PostMapping(value = "/trancheage/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerTrancheAge(@RequestBody TrancheAgeDs trancheAgeDs);

    @PutMapping(value = "/trancheage/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateTrancheAge(@PathVariable Long id, @RequestBody TrancheAgeDs trancheAgeDs);

    @GetMapping(value = "/trancheage/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TrancheAgeDs> findTrancheAgeById(@PathVariable Long id);

    @GetMapping(value = "/trancheage/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TrancheAgeDs>> findAllTrancheAges();

    @DeleteMapping(value = "/trancheage/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteTrancheAge(@PathVariable Long id);

    /***********************   TypeDocument    *******************/

    @PostMapping(value = "/typedocument/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerTypeDocument(@RequestBody TypeDocumentDs typeDocumentDs);

    @PutMapping(value = "/typedocument/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateTypeDocument(@PathVariable Long id, @RequestBody TypeDocumentDs typeDocumentDs) throws Exception;

    @GetMapping(value = "/typedocument/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeDocumentDs> findById(@PathVariable Long id);

    @GetMapping(value = "/typedocument/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TypeDocumentDs>> findAllTypeDocuments();

    @DeleteMapping(value = "/typedocument/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteTypeDocument(@PathVariable Long id);
}
