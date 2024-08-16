package com.iho.sn.referentiel.assembler;

import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.referentiel.entity.TrancheAge;
import com.iho.sn.referentiel.remote.model.CategoryMedicamentDs;
import com.iho.sn.referentiel.remote.model.ChambreDs;
import com.iho.sn.referentiel.remote.model.GroupeSanguinDs;
import com.iho.sn.referentiel.remote.model.LitDetailDs;
import com.iho.sn.referentiel.remote.model.LitDs;
import com.iho.sn.referentiel.remote.model.MedicamentDetailDs;
import com.iho.sn.referentiel.remote.model.MedicamentDs;
import com.iho.sn.referentiel.remote.model.ServicePartenaireDs;
import com.iho.sn.referentiel.remote.model.TrancheAgeDs;
import com.iho.sn.referentiel.service.ReferentielService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReferentielAssembler {

    private final ReferentielService referentielService;

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

    public List<TrancheAgeDs> assembleEntitiesFromListTrancheAge(List<TrancheAge> trancheAges) {
        return trancheAges.stream().map(this::assembleTrancheAgeDsfromEntity).toList();
    }
    public TrancheAgeDs assembleTrancheAgeDsfromEntity(TrancheAge trancheAge) {
        TrancheAgeDs trancheAgeDs = new TrancheAgeDs();
        trancheAgeDs.setId(trancheAge.getId());
        trancheAgeDs.setCode(trancheAge.getCode());
        trancheAgeDs.setLibelle(trancheAge.getLibelle());
        trancheAgeDs.setActif(trancheAge.isActif());
        return trancheAgeDs;
    }

    public TrancheAge assembleTrancheAgefromDs(TrancheAgeDs trancheAgeDs) {
        TrancheAge trancheAge = new TrancheAge();
        trancheAge.setId(trancheAgeDs.getId());
        trancheAge.setCode(trancheAgeDs.getCode());
        trancheAge.setLibelle(trancheAgeDs.getLibelle());
        trancheAge.setActif(trancheAgeDs.isActif());
        return trancheAge;
    }








}
