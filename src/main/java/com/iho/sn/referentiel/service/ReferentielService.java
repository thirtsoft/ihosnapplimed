package com.iho.sn.referentiel.service;

import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.referentiel.entity.TrancheAge;

import java.util.List;

public interface ReferentielService {

    Long saveCategoryMedicament(CategoryMedicament medicament) throws Exception;

    Long updateCategoryMedicament(Long id, CategoryMedicament medicament) throws Exception;

    CategoryMedicament findCategoryMedicamentById(Long id);

    CategoryMedicament findCategoryMedicamentByCode(String code);

    List<CategoryMedicament> findAllCategoryMedicaments();

    void deleteCategoryMedicament(Long id);

    Long saveMedicament(Medicament medicament) throws Exception;

    Long updateMedicament(Long id, Medicament medicament) throws Exception;

    Medicament findById(Long id);

    Medicament findByCode(String code);

    List<Medicament> findAllMedicaments();

    void deleteMedicament(Long id);

    Long saveChambre(Chambre chambre) throws Exception;

    Long updateChambre(Long id, Chambre chambre) throws Exception;

    Chambre findChambreById(Long id);

    Chambre findChambreByCode(String code);

    List<Chambre> findAllChambres();

    void deleteChambre(Long id);

    Long saveLit(Lit lit) throws Exception;

    Long updateLit(Long id, Lit lit) throws Exception;

    Lit findLitById(Long id);

    Lit findLitByCode(String code);

    List<Lit> findAllLits();

    void deleteLit(Long id);

    Long saveServicePartenaire(ServicePartenaire servicePartenaire) throws Exception;

    Long updateServicePartenaire(Long id, ServicePartenaire servicePartenaire) throws Exception;

    ServicePartenaire findServicePartenaireById(Long id);

    ServicePartenaire findServicePartenaireByCode(String code);

    List<ServicePartenaire> findAllServicePartenaires();

    void deleteServicePartenaire(Long id);

    Long saveGroupeSanguin(GroupeSanguin groupeSanguin) throws Exception;

    Long updateGroupeSanguin(Long id, GroupeSanguin groupeSanguin) throws Exception;

    GroupeSanguin findGroupeSanguinById(Long id);

    GroupeSanguin findGroupeSanguinByCode(String code);

    List<GroupeSanguin> findAllGroupeSanguins();

    void deleteGroupeSanguin(Long id);

    Long saveTrancheAge(TrancheAge trancheAge) throws Exception;

    Long updateTrancheAge(Long id, TrancheAge trancheAge) throws Exception;

    TrancheAge findTrancheAgeById(Long id);

    TrancheAge findTrancheAgeByCode(String code);

    List<TrancheAge> findAllTrancheAges();

    void deleteTrancheAge(Long id);
}
