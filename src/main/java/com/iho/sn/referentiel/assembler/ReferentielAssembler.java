package com.iho.sn.referentiel.assembler;

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
import com.iho.sn.referentiel.entity.SousElementDermatoseInf;
import com.iho.sn.referentiel.entity.SousElementHypothese;
import com.iho.sn.referentiel.entity.TypeDocument;
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
import com.iho.sn.referentiel.remote.model.SousElementDermatoseInfDs;
import com.iho.sn.referentiel.remote.model.SousElementHypotheseDs;
import com.iho.sn.referentiel.remote.model.TypeDocumentDs;
import com.iho.sn.referentiel.repository.ElementHypotheseRepository;
import com.iho.sn.referentiel.repository.SousElementHypotheseRepository;
import com.iho.sn.referentiel.service.ElementConsultationService;
import com.iho.sn.referentiel.service.ReferentielService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ReferentielAssembler {

    private final ReferentielService referentielService;
    private final ElementConsultationService elementConsultationService;

    public List<CategoryMedicamentDs> assembleEntitiesFromListCategoryMedicament(List<CategoryMedicament> categoryMedicaments) {
        return categoryMedicaments.stream().map(this::assembleCategoryMedicamentDsFromEntity).toList();
    }

    public CategoryMedicamentDs assembleCategoryMedicamentDsFromEntity(CategoryMedicament categoryMedicament) {
        CategoryMedicamentDs categoryMedicamentDs = new CategoryMedicamentDs();
        categoryMedicamentDs.setId(categoryMedicament.getId());
        categoryMedicamentDs.setCode(categoryMedicament.getCode());
        categoryMedicamentDs.setLibelle(categoryMedicament.getLibelle());
        categoryMedicamentDs.setActif(categoryMedicament.isActif());
        return categoryMedicamentDs;
    }

    public CategoryMedicament assembleCategoryMedicamentFromDs(CategoryMedicamentDs categoryMedicamentDs) {
        CategoryMedicament categoryMedicament = new CategoryMedicament();
        categoryMedicament.setId(categoryMedicamentDs.getId());
        categoryMedicament.setCode(categoryMedicamentDs.getCode());
        categoryMedicament.setLibelle(categoryMedicamentDs.getLibelle());
        categoryMedicament.setActif(categoryMedicamentDs.isActif());
        return categoryMedicament;
    }

    public List<ChambreDs> assembleEntitiesFromListChambre(List<Chambre> chambreList) {
        return chambreList.stream().map(this::assembleChambreDsfromEntity).toList();
    }

    public ChambreDs assembleChambreDsfromEntity(Chambre chambre) {
        ChambreDs chambreDs = new ChambreDs();
        chambreDs.setId(chambre.getId());
        chambreDs.setCode(chambre.getCode());
        chambreDs.setLibelle(chambre.getLibelle());
        chambreDs.setNbreLit(chambre.getNbreLit());
        chambreDs.setActif(chambre.isActif());
        return chambreDs;
    }

    public Chambre assembleChambrefromDs(ChambreDs chambreDs) {
        Chambre chambre = new Chambre();
        chambre.setId(chambreDs.getId());
        chambre.setCode(chambreDs.getCode());
        chambre.setLibelle(chambreDs.getLibelle());
        chambre.setNbreLit(chambreDs.getNbreLit());
        chambre.setActif(chambreDs.isActif());
        return chambre;
    }

    public List<GroupeSanguinDs> assembleEntitiesFromListGroupeSanguin(List<GroupeSanguin> groupeSanguins) {
        return groupeSanguins.stream().map(this::assembleGroupeSanguinDsfromEntity).toList();
    }

    public GroupeSanguinDs assembleGroupeSanguinDsfromEntity(GroupeSanguin groupeSanguin) {
        GroupeSanguinDs groupeSanguinDs = new GroupeSanguinDs();
        groupeSanguinDs.setId(groupeSanguin.getId());
        groupeSanguinDs.setCode(groupeSanguin.getCode());
        groupeSanguinDs.setDescription(groupeSanguin.getDescription());
        groupeSanguinDs.setActif(groupeSanguin.isActif());
        return groupeSanguinDs;
    }

    public GroupeSanguin assembleGroupeSanguinfromDs(GroupeSanguinDs groupeSanguinDs) {
        GroupeSanguin groupeSanguin = new GroupeSanguin();
        groupeSanguin.setId(groupeSanguinDs.getId());
        groupeSanguin.setCode(groupeSanguinDs.getCode());
        groupeSanguin.setDescription(groupeSanguinDs.getDescription());
        groupeSanguin.setActif(groupeSanguinDs.isActif());
        return groupeSanguin;
    }

    public List<LitDetailDs> assembleEntitiesFromListLit(List<Lit> lits) {
        return lits.stream().map(this::assembleLitDetailDsfromEntity).toList();
    }

    public LitDs assembleLitDsfromEntity(Lit lit) {
        LitDs litDs = new LitDs();
        litDs.setId(lit.getId());
        litDs.setNumero(lit.getNumero());
        litDs.setEstDisponible(lit.getEstDisponible());
        litDs.setActif(lit.isActif());
        if (lit.getChambreId() != null) {
            Chambre chambre = referentielService.findChambreById(lit.getChambreId());
            litDs.setChambreDs(assembleChambreDsfromEntity(chambre));
        }
        return litDs;
    }

    public Lit assembleLitfromDs(LitDs litDs) {
        Lit lit = new Lit();
        lit.setId(litDs.getId());
        lit.setNumero(litDs.getNumero());
        lit.setEstDisponible(litDs.getEstDisponible());
        lit.setActif(litDs.isActif());
        if (litDs.getChambreDs() != null) {
            lit.setChambreId(litDs.getChambreDs().getId());
        }
        return lit;
    }

    public LitDetailDs assembleLitDetailDsfromEntity(Lit lit) {
        LitDetailDs litDs = new LitDetailDs();
        litDs.setId(lit.getId());
        litDs.setNumero(lit.getNumero());
        litDs.setEstDisponible(lit.getEstDisponible());
        litDs.setActif(lit.isActif());
        if (lit.getChambreId() != null) {
            litDs.setChambreDs(assembleChambreDsfromEntity(
                    referentielService.findChambreById(lit.getChambreId())
            ));
        }
        return litDs;
    }

    public List<MedicamentDetailDs> assembleEntitiesFromListMedicament(List<Medicament> medicaments) {
        return medicaments.stream().map(this::assembleMedicamentDetailDsfromEntity).toList();
    }

    public MedicamentDs assembleMedicamentDsfromEntity(Medicament medicament) {
        MedicamentDs medicamentDs = new MedicamentDs();
        medicamentDs.setId(medicament.getId());
        medicamentDs.setCode(medicament.getCode());
        medicamentDs.setLibelle(medicament.getLibelle());
        if (medicament.getCategoryMedicamentId() != null) {
            CategoryMedicament categoryMedicament = referentielService.findCategoryMedicamentById(
                    medicament.getCategoryMedicamentId()
            );
            medicamentDs.setCategoryMedicamentDs(assembleCategoryMedicamentDsFromEntity(categoryMedicament));
        }
        medicamentDs.setActif(medicament.isActif());
        return medicamentDs;
    }

    public Medicament assembleMedicamentfromDs(MedicamentDs medicamentDs) {
        Medicament medicament = new Medicament();
        medicament.setId(medicamentDs.getId());
        medicament.setCode(medicamentDs.getCode());
        medicament.setLibelle(medicamentDs.getLibelle());
        if (medicamentDs.getCategoryMedicamentDs() != null) {
            medicament.setCategoryMedicamentId(medicamentDs.getCategoryMedicamentDs().getId());
        }
        medicament.setActif(medicamentDs.isActif());
        return medicament;
    }

    public MedicamentDetailDs assembleMedicamentDetailDsfromEntity(Medicament medicament) {
        MedicamentDetailDs medicamentDs = new MedicamentDetailDs();
        medicamentDs.setId(medicament.getId());
        medicamentDs.setCode(medicament.getCode());
        medicamentDs.setLibelle(medicament.getLibelle());
        if (medicament.getCategoryMedicamentId() != null) {
            medicamentDs.setCategoryMedicamentDs(assembleCategoryMedicamentDsFromEntity(
                    referentielService.findCategoryMedicamentById(medicament.getCategoryMedicamentId())
            ));
        }
        medicamentDs.setActif(medicament.isActif());
        return medicamentDs;
    }

    public List<ServicePartenaireDs> assembleEntitiesFromListServicePartenaire(List<ServicePartenaire> servicePartenaires) {
        return servicePartenaires.stream().map(this::assembleServicePartenaireDsfromEntity).toList();
    }

    public ServicePartenaireDs assembleServicePartenaireDsfromEntity(ServicePartenaire servicePartenaire) {
        ServicePartenaireDs servicePartenaireDs = new ServicePartenaireDs();
        servicePartenaireDs.setId(servicePartenaire.getId());
        servicePartenaireDs.setCode(servicePartenaire.getCode());
        servicePartenaireDs.setLibelle(servicePartenaire.getLibelle());
        servicePartenaireDs.setDescription(servicePartenaire.getDescription());
        servicePartenaireDs.setActif(servicePartenaire.isActif());
        return servicePartenaireDs;
    }

    public ServicePartenaire assembleServicePartenairefromDs(ServicePartenaireDs servicePartenaireDs) {
        ServicePartenaire servicePartenaire = new ServicePartenaire();
        servicePartenaire.setId(servicePartenaireDs.getId());
        servicePartenaire.setCode(servicePartenaireDs.getCode());
        servicePartenaire.setLibelle(servicePartenaireDs.getLibelle());
        servicePartenaire.setDescription(servicePartenaireDs.getDescription());
        servicePartenaire.setActif(servicePartenaireDs.isActif());
        return servicePartenaire;
    }

    public TypeDocument assembleTypeDocumentFromDs(TypeDocumentDs typeDocumentDs) {
        TypeDocument typeDocument = new TypeDocument();
        typeDocument.setId(typeDocumentDs.getId());
        typeDocument.setCode(typeDocumentDs.getCode());
        typeDocument.setLibelle(typeDocumentDs.getLibelle());
        typeDocument.setActif(typeDocumentDs.isActif());
        return typeDocument;
    }

    public TypeDocumentDs assembleTypeDocumentFromEntity(TypeDocument typeDocument) {
        TypeDocumentDs typeDocumentDs = new TypeDocumentDs();
        typeDocumentDs.setId(typeDocument.getId());
        typeDocumentDs.setCode(typeDocument.getCode());
        typeDocumentDs.setLibelle(typeDocument.getLibelle());
        typeDocumentDs.setActif(typeDocument.isActif());
        return typeDocumentDs;
    }

    public List<TypeDocumentDs> assembleEntitiesFromListTypeDocument(List<TypeDocument> typeDocuments) {
        return typeDocuments.stream().map(this::assembleTypeDocumentFromEntity).toList();
    }

    /*********************                 *******************/

    public List<DermatoseAutoimineDs> assembleEntitiesFromListDermatoseAutoimine(List<DermatoseAutoimine> dermatoseAutoimines) {
        return dermatoseAutoimines.stream().map(this::assembleDermatoseAutoimineDsFromEntity).toList();
    }

    public DermatoseAutoimineDs assembleDermatoseAutoimineDsFromEntity(DermatoseAutoimine dermatoseAutoimine) {
        DermatoseAutoimineDs dermatoseAutoimineDs = new DermatoseAutoimineDs();
        dermatoseAutoimineDs.setLibelle(dermatoseAutoimine.getLibelle());
        dermatoseAutoimineDs.setActif(dermatoseAutoimine.isActif());
        return dermatoseAutoimineDs;
    }

    public DermatoseAutoimine assembleDermatoseAutoimineFromDs(DermatoseAutoimineDs dermatoseAutoimineDs) {
        DermatoseAutoimine dermatoseAutoimine = new DermatoseAutoimine();
        dermatoseAutoimine.setLibelle(dermatoseAutoimineDs.getLibelle());
        dermatoseAutoimine.setActif(dermatoseAutoimineDs.isActif());
        return dermatoseAutoimine;
    }

    /***************  Bulleuse   *************/

    public List<DermatoseBulleuseDs> assembleEntitiesFromListDermatoseBulleuse(List<DermatoseBulleuse> dermatoseBulleuses) {
        return dermatoseBulleuses.stream().map(this::assembleDermatoseBulleuseDsFromEntity).toList();
    }

    public DermatoseBulleuseDs assembleDermatoseBulleuseDsFromEntity(DermatoseBulleuse dermatoseBulleuse) {
        DermatoseBulleuseDs dermatoseBulleuseDs = new DermatoseBulleuseDs();
        dermatoseBulleuseDs.setLibelle(dermatoseBulleuse.getLibelle());
        dermatoseBulleuseDs.setActif(dermatoseBulleuse.isActif());
        return dermatoseBulleuseDs;
    }

    public DermatoseBulleuse assembleDermatoseBulleuseFromDs(DermatoseBulleuseDs dermatoseBulleuseDs) {
        DermatoseBulleuse dermatoseBulleuse = new DermatoseBulleuse();
        dermatoseBulleuse.setLibelle(dermatoseBulleuseDs.getLibelle());
        dermatoseBulleuse.setActif(dermatoseBulleuseDs.isActif());
        return dermatoseBulleuse;
    }

    /***************  InfBacterienne   *************/

    public List<DermatoseInfBacterienneDs> assembleEntitiesFromListDermatoseInfBacterienne(List<DermatoseInfBacterienne> dermatoseInfBacteriennes) {
        return dermatoseInfBacteriennes.stream().map(this::assembleDermatoseInfBacterienneDsFromEntity).toList();
    }

    public DermatoseInfBacterienneDs assembleDermatoseInfBacterienneDsFromEntity(DermatoseInfBacterienne dermatoseInfBacterienne) {
        DermatoseInfBacterienneDs dermatoseInfBacterienneDs = new DermatoseInfBacterienneDs();
        dermatoseInfBacterienneDs.setLibelle(dermatoseInfBacterienne.getLibelle());
        dermatoseInfBacterienneDs.setActif(dermatoseInfBacterienne.isActif());
        return dermatoseInfBacterienneDs;
    }

    public DermatoseInfBacterienne assembleDermatoseInfBacterienneFromDs(DermatoseInfBacterienneDs dermatoseInfBacterienneDs) {
        DermatoseInfBacterienne dermatoseInfBacterienne = new DermatoseInfBacterienne();
        dermatoseInfBacterienne.setLibelle(dermatoseInfBacterienneDs.getLibelle());
        dermatoseInfBacterienne.setActif(dermatoseInfBacterienneDs.isActif());
        return dermatoseInfBacterienne;
    }

    /***************  Infectieuse   *************/

    public List<DermatoseInfectieuseDs> assembleEntitiesFromListDermatoseInfectieuse(List<DermatoseInfectieuse> infectieuses) {
        return infectieuses.stream().map(this::assembleDermatoseInfectieuseDsFromEntity).toList();
    }

    public DermatoseInfectieuseDs assembleDermatoseInfectieuseDsFromEntity(DermatoseInfectieuse dermatoseInfectieuse) {
        DermatoseInfectieuseDs dermatoseInfectieuseDs = new DermatoseInfectieuseDs();
        dermatoseInfectieuseDs.setLibelle(dermatoseInfectieuse.getLibelle());
        dermatoseInfectieuseDs.setActif(dermatoseInfectieuse.isActif());
        return dermatoseInfectieuseDs;
    }

    public DermatoseInfectieuse assembleDermatoseInfectieuseFromDs(DermatoseInfectieuseDs dermatoseInfectieuseDs) {
        DermatoseInfectieuse dermatoseInfectieuse = new DermatoseInfectieuse();
        dermatoseInfectieuse.setLibelle(dermatoseInfectieuseDs.getLibelle());
        dermatoseInfectieuse.setActif(dermatoseInfectieuseDs.isActif());
        return dermatoseInfectieuse;
    }

    /***************  Inflammatoire   *************/

    public List<DermatoseInflammatoireDs> assembleEntitiesFromListDermatoseInflammatoire(List<DermatoseInflammatoire> inflammatoires) {
        return inflammatoires.stream().map(this::assembleDermatoseInflammatoireDsFromEntity).toList();
    }

    public DermatoseInflammatoireDs assembleDermatoseInflammatoireDsFromEntity(DermatoseInflammatoire dermatoseInflammatoire) {
        DermatoseInflammatoireDs dermatoseInflammatoireDs = new DermatoseInflammatoireDs();
        dermatoseInflammatoireDs.setLibelle(dermatoseInflammatoire.getLibelle());
        dermatoseInflammatoireDs.setActif(dermatoseInflammatoire.isActif());
        return dermatoseInflammatoireDs;
    }

    public DermatoseInflammatoire assembleDermatoseInflammatoireFromDs(DermatoseInflammatoireDs dermatoseInflammatoireDs) {
        DermatoseInflammatoire dermatoseInflammatoire = new DermatoseInflammatoire();
        dermatoseInflammatoire.setLibelle(dermatoseInflammatoireDs.getLibelle());
        dermatoseInflammatoire.setActif(dermatoseInflammatoireDs.isActif());
        return dermatoseInflammatoire;
    }

    /***************  Viral   *************/

    public List<DermatoseInfViraleDs> assembleEntitiesFromListDermatoseInfVirale(List<DermatoseInfVirale> dermatoseInfVirales) {
        return dermatoseInfVirales.stream().map(this::assembleDermatoseInfViraleDsFromEntity).toList();
    }

    public DermatoseInfViraleDs assembleDermatoseInfViraleDsFromEntity(DermatoseInfVirale dermatoseInfVirale) {
        DermatoseInfViraleDs dermatoseInfViraleDs = new DermatoseInfViraleDs();
        dermatoseInfViraleDs.setLibelle(dermatoseInfVirale.getLibelle());
        dermatoseInfViraleDs.setActif(dermatoseInfVirale.isActif());
        return dermatoseInfViraleDs;
    }

    public DermatoseInfVirale assembleDermatoseInfViraleDs(DermatoseInfViraleDs dermatoseInfViraleDs) {
        DermatoseInfVirale dermatoseInfVirale = new DermatoseInfVirale();
        dermatoseInfVirale.setLibelle(dermatoseInfViraleDs.getLibelle());
        dermatoseInfVirale.setActif(dermatoseInfViraleDs.isActif());
        return dermatoseInfVirale;
    }

    /***************  Examen Dermatologique   *************/

    public List<ElementExamenDermatologiqueDs> assembleEntitiesFromListElementExamenDermatologique(List<ElementExamenDermatologique> elementExamenDermatologiques) {
        return elementExamenDermatologiques.stream().map(this::assembleElementExamenDermatologiqueDsFromEntity).toList();
    }

    public List<ElementExamenDermatologiqueDs> createListeElementExamenDermatologiqueDs(Set<Long> examDermato) {
        List<ElementExamenDermatologiqueDs> dtos = new ArrayList<>();
        for (Long id : examDermato)
            dtos.add(assembleElementExamenDermatologiqueDsFromEntity(elementConsultationService.findElementExamenDermatologiqueById(id)));
        return dtos;
    }

    public Set<Long> createSetElementExamenDermatologique(List<ElementExamenDermatologiqueDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> elementExamenDermatologiques = new HashSet<>();
        for (ElementExamenDermatologiqueDs dto : dtos)
            if (dto != null)
                elementExamenDermatologiques.add(dto.getId());
        return elementExamenDermatologiques;
    }

    public ElementExamenDermatologiqueDs assembleElementExamenDermatologiqueDsFromEntity(ElementExamenDermatologique elementExamenDermatologique) {
        ElementExamenDermatologiqueDs elementExamenDermatologiqueDs = new ElementExamenDermatologiqueDs();
        elementExamenDermatologiqueDs.setId(elementExamenDermatologique.getId());
        elementExamenDermatologiqueDs.setLibelle(elementExamenDermatologique.getLibelle());
        elementExamenDermatologiqueDs.setActif(elementExamenDermatologique.isActif());
        return elementExamenDermatologiqueDs;
    }

    public ElementExamenDermatologique assembleElementExamenDermatologiqueFromDs(ElementExamenDermatologiqueDs elementExamenDermatologiqueDs) {
        ElementExamenDermatologique elementExamenDermatologique = new ElementExamenDermatologique();
        elementExamenDermatologique.setId(elementExamenDermatologiqueDs.getId());
        elementExamenDermatologique.setLibelle(elementExamenDermatologiqueDs.getLibelle());
        elementExamenDermatologique.setActif(elementExamenDermatologiqueDs.isActif());
        return elementExamenDermatologique;
    }

    /***************  Hypothese   *************/

    public List<ElementHypotheseDs> assembleEntitiesFromListElementHypothese(List<ElementHypothese> elementHypothese) {
        return elementHypothese.stream().map(this::assembleElementElementHypotheseDsFromEntity).toList();
    }

    /*
    public List<ElementHypotheseDs> createListeElementHypotheseDs(Set<Long> hyptothese) {
        List<ElementHypotheseDs> dtos = new ArrayList<>();
        for (Long id : hyptothese)
            dtos.add(assembleElementElementHypotheseDsFromEntity(elementConsultationService.findElementHypotheseById(id)));
        return dtos;
    }

    public Set<Long> createSetElementHypothese(List<ElementHypotheseDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> elementHypotheses = new HashSet<>();
        for (ElementHypotheseDs dto : dtos)
            if (dto != null)
                elementHypotheses.add(dto.getId());
        return elementHypotheses;
    }*/

    public List<ElementHypotheseDs> createListElementHypotheseDs(Set<ElementHypothese> elementHypotheseSet) {
        if (elementHypotheseSet == null)
            return Collections.emptyList();
        List<ElementHypotheseDs> dtos = new ArrayList<>();
        for (ElementHypothese model : elementHypotheseSet)
            dtos.add(assembleElementElementHypotheseDsFromEntity(model));
        return dtos;
    }

    public Set<ElementHypothese> createSetElementHypothese(List<ElementHypotheseDs> dtos) {
        if (dtos == null)
            return null;
        Set<ElementHypothese> elementHypotheseSet = new HashSet<>();
        for (ElementHypotheseDs dto : dtos)
            if (dto != null)
                elementHypotheseSet.add(assembleElementHypotheseFromDs(dto));
        return elementHypotheseSet;
    }

    public ElementHypotheseDs assembleElementElementHypotheseDsFromEntity(ElementHypothese elementHypothese) {
        ElementHypotheseDs elementHypotheseDs = new ElementHypotheseDs();
        elementHypotheseDs.setId(elementHypothese.getId());
        elementHypotheseDs.setLibelle(elementHypothese.getLibelle());
        elementHypotheseDs.setActif(elementHypothese.isActif());
        elementHypotheseDs.setSousElementHypotheseDs(createListSousElementHypotheseDs
                (elementHypothese.getSousElementHypothese()));
        return elementHypotheseDs;
    }

    private final ElementHypotheseRepository elementHypotheseRepository;

    public ElementHypothese assembleElementHypotheseFromDs(ElementHypotheseDs elementHypotheseDs) {
    //    ElementHypothese elementHypothese = new ElementHypothese();
        ElementHypothese elementHypothese = elementHypotheseRepository.findElementHypotheseById(elementHypotheseDs.getId());
        elementHypothese.setId(elementHypotheseDs.getId());
        elementHypothese.setLibelle(elementHypotheseDs.getLibelle());
        elementHypothese.setActif(elementHypotheseDs.isActif());
        elementHypothese.setSousElementHypothese(createSetSousElementHypothese(elementHypotheseDs.getSousElementHypotheseDs()));
        return elementHypothese;
    }

    /***************  SousElementHypotheseDs   *************/

    /*
    public List<SousElementHypotheseDs> createListeSousElementHypotheseDs(Set<Long> sousElementHypothese) {
        List<SousElementHypotheseDs> dtos = new ArrayList<>();
        for (Long id : sousElementHypothese)
            dtos.add(assembleSousElementHypotheseDsFromEntity(elementConsultationService.findSousElementHypotheseById(id)));
        return dtos;
    }

    public Set<Long> createSetSousElementHypotheseDs(List<SousElementHypotheseDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> sousElementHypotheses = new HashSet<>();
        for (SousElementHypotheseDs dto : dtos)
            if (dto != null)
                sousElementHypotheses.add(dto.getId());
        return sousElementHypotheses;
    }*/
    public List<SousElementHypotheseDs> createListSousElementHypotheseDs(Set<SousElementHypothese> sousElementHypothese) {
        if (sousElementHypothese == null)
            return Collections.emptyList();
        List<SousElementHypotheseDs> dtos = new ArrayList<>();
        for (SousElementHypothese model : sousElementHypothese)
            dtos.add(assembleSousElementHypotheseDsFromEntity(model));
        return dtos;
    }

    public Set<SousElementHypothese> createSetSousElementHypothese(List<SousElementHypotheseDs> dtos) {
        if (dtos == null)
            return null;
        Set<SousElementHypothese> sousElementHypothese = new HashSet<>();
        for (SousElementHypotheseDs dto : dtos)
            if (dto != null)
                sousElementHypothese.add(assembleSousElementHypotheseFromDs(dto));
        return sousElementHypothese;
    }


    public List<SousElementHypotheseDs> assembleEntitiesFromListSousElementHypothese(List<SousElementHypothese> sousElementHypothese) {
        return sousElementHypothese.stream().map(this::assembleSousElementHypotheseDsFromEntity).toList();
    }

    public SousElementHypotheseDs assembleSousElementHypotheseDsFromEntity(SousElementHypothese sousElementHypothese) {
        return SousElementHypotheseDs.builder()
                .id(sousElementHypothese.getId())
                .libelle(sousElementHypothese.getLibelle())
                .sousElementDermatoseInfDs(createListeSousElementDermatoseInfDs(sousElementHypothese.getSousElementDermatoseInfs()))
                .actif(sousElementHypothese.getActif())
                .build();
    }

    private final SousElementHypotheseRepository sousElementHypotheseRepository;

    public SousElementHypothese assembleSousElementHypotheseFromDs(SousElementHypotheseDs sousElementHypotheseDs) {
    //    SousElementHypothese sousElementHypothese = new SousElementHypothese();
        SousElementHypothese sousElementHypothese = sousElementHypotheseRepository.findSousElementHypotheseById(sousElementHypotheseDs.getId());
        sousElementHypothese.setId(sousElementHypotheseDs.getId());
        sousElementHypothese.setLibelle(sousElementHypotheseDs.getLibelle());
        sousElementHypothese.setSousElementDermatoseInfs(createSetSousElementDermatoseInfDs
                (sousElementHypotheseDs.getSousElementDermatoseInfDs()));
        sousElementHypothese.setActif(sousElementHypotheseDs.isActif());
        return sousElementHypothese;
    }

    /***************  SousElementDermatoseInfDs   *************/

    public List<SousElementDermatoseInfDs> createListeSousElementDermatoseInfDs(Set<Long> sousElementDermatoseInf) {
        List<SousElementDermatoseInfDs> dtos = new ArrayList<>();
        for (Long id : sousElementDermatoseInf)
            dtos.add(assembleSousElementDermatoseInfDsFromEntity(elementConsultationService.findSousElementDermatoseInfById(id)));
        return dtos;
    }

    public Set<Long> createSetSousElementDermatoseInfDs(List<SousElementDermatoseInfDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> sousElementHypotheseInfs = new HashSet<>();
        for (SousElementDermatoseInfDs dto : dtos)
            if (dto != null)
                sousElementHypotheseInfs.add(dto.getId());
        return sousElementHypotheseInfs;
    }

    public List<SousElementDermatoseInfDs> createListSousElementDermatoseInfDs(Set<SousElementDermatoseInf> sousElementDermatoseInfs) {
        if (sousElementDermatoseInfs == null)
            return Collections.emptyList();
        List<SousElementDermatoseInfDs> dtos = new ArrayList<>();
        for (SousElementDermatoseInf model : sousElementDermatoseInfs)
            dtos.add(assembleSousElementDermatoseInfDsFromEntity(model));
        return dtos;
    }

    public Set<SousElementDermatoseInf> createSetSousElementDermatoseInf(List<SousElementDermatoseInfDs> dtos) {
        if (dtos == null)
            return null;
        Set<SousElementDermatoseInf> sousElementDermatoseInfs = new HashSet<>();
        for (SousElementDermatoseInfDs dto : dtos)
            if (dto != null)
                sousElementDermatoseInfs.add(assembleSousElementDermatoseInfFromDs(dto));
        return sousElementDermatoseInfs;
    }

    public SousElementDermatoseInfDs assembleSousElementDermatoseInfDsFromEntity(SousElementDermatoseInf sousElementDermatoseInf) {
        return SousElementDermatoseInfDs.builder()
                .id(sousElementDermatoseInf.getId())
                .libelle(sousElementDermatoseInf.getLibelle())
                .actif(sousElementDermatoseInf.getActif())
                .build();
    }

    public SousElementDermatoseInf assembleSousElementDermatoseInfFromDs(SousElementDermatoseInfDs sousElementDermatoseInfDs) {
        SousElementDermatoseInf sousElementDermatoseInf = new SousElementDermatoseInf();
        sousElementDermatoseInf.setId(sousElementDermatoseInfDs.getId());
        sousElementDermatoseInf.setLibelle(sousElementDermatoseInf.getLibelle());
        sousElementDermatoseInf.setActif(sousElementDermatoseInfDs.isActif());
        return sousElementDermatoseInf;
    }


    /***************  Plainte   *************/

    public List<ElementPlainteDs> assembleEntitiesFromLisElementPlainte(List<ElementPlainte> elementPlaintes) {
        return elementPlaintes.stream().map(this::assembleElementPlainteDsFromEntity).toList();
    }

    public List<ElementPlainteDs> createListeElementPlainteDs(Set<Long> plainte) {
        List<ElementPlainteDs> dtos = new ArrayList<>();
        for (Long id : plainte)
            dtos.add(assembleElementPlainteDsFromEntity(elementConsultationService.findElementPlainteById(id)));
        return dtos;
    }

    public Set<Long> createSetElementPlainte(List<ElementPlainteDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> elementPlaintes = new HashSet<>();
        for (ElementPlainteDs dto : dtos)
            if (dto != null)
                elementPlaintes.add(dto.getId());
        return elementPlaintes;
    }

    public ElementPlainteDs assembleElementPlainteDsFromEntity(ElementPlainte elementPlainte) {
        ElementPlainteDs elementPlainteDs = new ElementPlainteDs();
        elementPlainteDs.setId(elementPlainte.getId());
        elementPlainteDs.setLibelle(elementPlainte.getLibelle());
        elementPlainteDs.setActif(elementPlainte.isActif());
        return elementPlainteDs;
    }

    public ElementPlainte assembleElementPlainteFromDs(ElementPlainteDs elementPlainteDs) {
        ElementPlainte elementPlainte = new ElementPlainte();
        elementPlainte.setId(elementPlainteDs.getId());
        elementPlainte.setLibelle(elementPlainteDs.getLibelle());
        elementPlainte.setActif(elementPlainteDs.isActif());
        return elementPlainte;
    }

    /***************  Recherche   *************/

    public List<ElementRechercheNotionDs> assembleEntitiesFromListElementRechercheNotion(List<ElementRechercheNotion> elementRechercheNotions) {
        return elementRechercheNotions.stream().map(this::assembleElementRechercheNotionDsFromEntity).toList();
    }

    public List<ElementRechercheNotionDs> createListeElementRechercheNotionDs(Set<Long> rechercheNotion) {
        List<ElementRechercheNotionDs> dtos = new ArrayList<>();
        for (Long id : rechercheNotion)
            dtos.add(assembleElementRechercheNotionDsFromEntity(elementConsultationService.findElementRechercheNotionById(id)));
        return dtos;
    }

    public Set<Long> createSetElementRechercheNotion(List<ElementRechercheNotionDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> elementRechercheNotions = new HashSet<>();
        for (ElementRechercheNotionDs dto : dtos)
            if (dto != null)
                elementRechercheNotions.add(dto.getId());
        return elementRechercheNotions;
    }

    public ElementRechercheNotionDs assembleElementRechercheNotionDsFromEntity(ElementRechercheNotion elementRechercheNotion) {
        ElementRechercheNotionDs elementRechercheNotionDs = new ElementRechercheNotionDs();
        elementRechercheNotionDs.setId(elementRechercheNotion.getId());
        elementRechercheNotionDs.setLibelle(elementRechercheNotion.getLibelle());
        elementRechercheNotionDs.setActif(elementRechercheNotion.isActif());
        return elementRechercheNotionDs;
    }

    public ElementRechercheNotion assembleElementRechercheNotionFromDs(ElementRechercheNotionDs elementRechercheNotionDs) {
        ElementRechercheNotion elementRechercheNotion = new ElementRechercheNotion();
        elementRechercheNotion.setId(elementRechercheNotionDs.getId());
        elementRechercheNotion.setLibelle(elementRechercheNotionDs.getLibelle());
        elementRechercheNotion.setActif(elementRechercheNotionDs.isActif());
        return elementRechercheNotion;
    }

    /***************  Terrain   *************/

    public List<ElementTerrainDs> assembleEntitiesFromListElementTerrain(List<ElementTerrain> elementTerrains) {
        return elementTerrains.stream().map(this::assembleElementTerrainDsFromEntity).toList();
    }

    public List<ElementTerrainDs> createListeElementTerrainDs(Set<Long> terrain) {
        List<ElementTerrainDs> dtos = new ArrayList<>();
        for (Long id : terrain)
            dtos.add(assembleElementTerrainDsFromEntity(elementConsultationService.findElementTerrainById(id)));
        return dtos;
    }

    public Set<Long> createSetElementTerrain(List<ElementTerrainDs> dtos) {
        if (dtos == null)
            return null;
        Set<Long> elementTarrains = new HashSet<>();
        for (ElementTerrainDs dto : dtos)
            if (dto != null)
                elementTarrains.add(dto.getId());
        return elementTarrains;
    }

    public ElementTerrainDs assembleElementTerrainDsFromEntity(ElementTerrain elementTerrain) {
        ElementTerrainDs elementTerrainDs = new ElementTerrainDs();
        elementTerrainDs.setId(elementTerrain.getId());
        elementTerrainDs.setLibelle(elementTerrain.getLibelle());
        elementTerrainDs.setActif(elementTerrain.isActif());
        return elementTerrainDs;
    }

    public ElementTerrain assembleElementTerrainFromDs(ElementTerrainDs elementTerrainDs) {
        ElementTerrain elementTerrain = new ElementTerrain();
        elementTerrain.setId(elementTerrainDs.getId());
        elementTerrain.setLibelle(elementTerrainDs.getLibelle());
        elementTerrain.setActif(elementTerrainDs.isActif());
        return elementTerrain;
    }

}