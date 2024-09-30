package com.iho.sn.referentiel.remote.controller.api;

import com.iho.sn.admin.remote.model.ResponseMassageDs;
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

    /************   DermatoseAutoimine          *****/

    @PostMapping(value = "/dermatoseautoimine/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseAutoimine(@RequestBody DermatoseAutoimineDs dermatoseAutoimineDs);

    @PutMapping(value = "/dermatoseautoimine/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseAutoimine(@PathVariable Long id, @RequestBody DermatoseAutoimineDs dermatoseAutoimineDs);

    @GetMapping(value = "/dermatoseautoimine/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseAutoimineDs> findDermatoseAutoimineById(@PathVariable Long id);

    @GetMapping(value = "/dermatoseautoimine/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseAutoimineDs>> findAllDermatoseAutoimines();

    @DeleteMapping(value = "/dermatoseautoimine/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseAutoimine(@PathVariable Long id);

    /************   DermatoseBulleuse          *****/

    @PostMapping(value = "/dermatosebulleuse/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseBulleuse(@RequestBody DermatoseBulleuseDs dermatoseBulleuseDs);

    @PutMapping(value = "/dermatosebulleuse/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseBulleuse(@PathVariable Long id, @RequestBody DermatoseBulleuseDs dermatoseBulleuseDs);

    @GetMapping(value = "/dermatosebulleuse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseBulleuseDs> findDermatoseBulleuseById(@PathVariable Long id);

    @GetMapping(value = "/dermatosebulleuse/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseBulleuseDs>> findAllDermatoseBulleuses();

    @DeleteMapping(value = "/dermatosebulleuse/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseBulleuse(@PathVariable Long id);

    /************   DermatoseInfBacterienne          *****/

    @PostMapping(value = "/dermatoseinfbacterienne/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseInfBacterienne(@RequestBody DermatoseInfBacterienneDs dermatoseInfBacterienneDs);

    @PutMapping(value = "/dermatoseinfbacterienne/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseInfBacterienne(@PathVariable Long id, @RequestBody DermatoseInfBacterienneDs dermatoseInfBacterienneDs);

    @GetMapping(value = "/dermatoseinfbacterienne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseInfBacterienneDs> findDermatoseInfBacterienneById(@PathVariable Long id);

    @GetMapping(value = "/dermatoseinfbacterienne/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseInfBacterienneDs>> findAllDermatoseInfBacteriennes();

    @DeleteMapping(value = "/dermatoseinfbacterienne/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseInfBacterienne(@PathVariable Long id);

    /************   DermatoseInfectieuse          *****/

    @PostMapping(value = "/dermatoseinfectieuse/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseInfectieuse(@RequestBody DermatoseInfectieuseDs dermatoseInfectieuseDs);

    @PutMapping(value = "/dermatoseinfectieuse/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseInfectieuse(@PathVariable Long id, @RequestBody DermatoseInfectieuseDs dermatoseInfectieuseDs);

    @GetMapping(value = "/dermatoseinfectieuse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseInfectieuseDs> findDermatoseInfectieuseById(@PathVariable Long id);

    @GetMapping(value = "/dermatoseinfectieuse/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseInfectieuseDs>> findAllDermatoseInfectieuses();

    @DeleteMapping(value = "/dermatoseinfectieuse/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseInfectieuse(@PathVariable Long id);

    /************   DermatoseInflammatoire          *****/

    @PostMapping(value = "/dermatoseinflammatoire/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseInflammatoire(@RequestBody DermatoseInflammatoireDs dermatoseInflammatoireDs);

    @PutMapping(value = "/dermatoseinflammatoire/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseInflammatoire(@PathVariable Long id, @RequestBody DermatoseInflammatoireDs dermatoseInflammatoireDs);

    @GetMapping(value = "/dermatoseinflammatoire/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseInflammatoireDs> findDermatoseInflammatoireById(@PathVariable Long id);

    @GetMapping(value = "/dermatoseinflammatoire/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseInflammatoireDs>> findAllDermatoseInflammatoires();

    @DeleteMapping(value = "/dermatoseinflammatoire/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseInflammatoire(@PathVariable Long id);

    /************   DermatoseInfVirale          *****/

    @PostMapping(value = "/dermatoseinfvirale/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerDermatoseInfVirale(@RequestBody DermatoseInfViraleDs dermatoseInfViraleDs);

    @PutMapping(value = "/dermatoseinfvirale/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateDermatoseInfVirale(@PathVariable Long id, @RequestBody DermatoseInfViraleDs dermatoseInfViraleDs);

    @GetMapping(value = "/dermatoseinfvirale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DermatoseInfViraleDs> findDermatoseInfViraleById(@PathVariable Long id);

    @GetMapping(value = "/dermatoseinfvirale/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DermatoseInfViraleDs>> findAllDermatoseInfVirales();

    @DeleteMapping(value = "/dermatoseinfvirale/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteDermatoseInfVirale(@PathVariable Long id);

    /************   ElementExamenDermatologique          *****/

    @PostMapping(value = "/elementexamendermatologique/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerElementExamenDermatologique(@RequestBody ElementExamenDermatologiqueDs elementExamenDermatologiqueDs);

    @PutMapping(value = "/elementexamendermatologique/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateElementExamenDermatologique(@PathVariable Long id, @RequestBody ElementExamenDermatologiqueDs elementExamenDermatologiqueDs);

    @GetMapping(value = "/elementexamendermatologique/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ElementExamenDermatologiqueDs> findElementExamenDermatologiqueById(@PathVariable Long id);

    @GetMapping(value = "/elementexamendermatologique/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElementExamenDermatologiqueDs>> findAllElementExamenDermatologiques();

    @DeleteMapping(value = "/elementexamendermatologique/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteElementExamenDermatologique(@PathVariable Long id);

    /************   ElementHypothese          *****/

    @PostMapping(value = "/elementhypothese/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerElementHypothese(@RequestBody ElementHypotheseDs elementHypotheseDs);

    @PutMapping(value = "/elementhypothese/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateElementHypothese(@PathVariable Long id, @RequestBody ElementHypotheseDs elementHypotheseDs);

    @GetMapping(value = "/elementhypothese/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ElementHypotheseDs> findElementHypotheseById(@PathVariable Long id);

    @GetMapping(value = "/elementhypothese/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElementHypotheseDs>> findAllElementHypotheses();

    @DeleteMapping(value = "/elementhypothese/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteElementHypothese(@PathVariable Long id);

    /************   ElementPlainte          *****/

    @PostMapping(value = "/elementplainte/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerElementPlainte(@RequestBody ElementPlainteDs elementPlainteDs);

    @PutMapping(value = "/elementplainte/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateElementPlainte(@PathVariable Long id, @RequestBody ElementPlainteDs elementPlainteDs);

    @GetMapping(value = "/elementplainte/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ElementPlainteDs> findElementPlainteById(@PathVariable Long id);

    @GetMapping(value = "/elementplainte/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElementPlainteDs>> findAllElementPlaintes();

    @DeleteMapping(value = "/elementplainte/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteElementPlainte(@PathVariable Long id);

    /************   ElementRechercheNotion          *****/

    @PostMapping(value = "/elementrecherchenotion/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerElementRechercheNotion(@RequestBody ElementRechercheNotionDs elementRechercheNotionDs);

    @PutMapping(value = "/elementrecherchenotion/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateElementRechercheNotion(@PathVariable Long id, @RequestBody ElementRechercheNotionDs elementRechercheNotionDs);

    @GetMapping(value = "/elementrecherchenotion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ElementRechercheNotionDs> findElementRechercheNotionById(@PathVariable Long id);

    @GetMapping(value = "/elementrecherchenotion/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElementRechercheNotionDs>> findAllElementRechercheNotions();

    @DeleteMapping(value = "/elementrecherchenotion/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteElementRechercheNotion(@PathVariable Long id);

    /************   ElementTerrain          *****/

    @PostMapping(value = "/elementterrain/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerElementTerrain(@RequestBody ElementTerrainDs elementTerrainDs);

    @PutMapping(value = "/elementterrain/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs updateElementTerrain(@PathVariable Long id, @RequestBody ElementTerrainDs elementTerrainDs);

    @GetMapping(value = "/elementterrain/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ElementTerrainDs> findElementTerrainById(@PathVariable Long id);

    @GetMapping(value = "/elementterrain/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ElementTerrainDs>> findAllElementTerrains();

    @DeleteMapping(value = "/elementterrain/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteElementTerrain(@PathVariable Long id);
}
