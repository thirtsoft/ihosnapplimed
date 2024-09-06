package com.iho.sn.referentiel.service;

import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.dossiermedical.patient.entity.TrancheAge;
import com.iho.sn.referentiel.entity.TypeDocument;
import com.iho.sn.referentiel.exception.ReferentielException;

import java.util.List;

public interface ReferentielService {

    Long saveCategoryMedicament(CategoryMedicament medicament) throws ReferentielException;

    Long updateCategoryMedicament(Long id, CategoryMedicament medicament) throws ReferentielException;

    CategoryMedicament findCategoryMedicamentById(Long id);

    CategoryMedicament findCategoryMedicamentByCode(String code);

    List<CategoryMedicament> findAllCategoryMedicaments();

    void deleteCategoryMedicament(Long id);

    Long saveMedicament(Medicament medicament) throws ReferentielException;

    Long updateMedicament(Long id, Medicament medicament) throws ReferentielException;

    Medicament findById(Long id);

    Medicament findByCode(String code);

    List<Medicament> findAllMedicaments();

    void deleteMedicament(Long id);

    Long saveChambre(Chambre chambre) throws ReferentielException;

    Long updateChambre(Long id, Chambre chambre) throws ReferentielException;

    Chambre findChambreById(Long id);

    Chambre findChambreByCode(String code);

    List<Chambre> findAllChambres();

    void deleteChambre(Long id);

    Long saveLit(Lit lit) throws ReferentielException;

    Long updateLit(Long id, Lit lit) throws ReferentielException;

    void changerEtatLitAOccupe(Long litId, int etat);

    void amenerLitEnreparation(Long litId, int etat);

    Lit findLitById(Long id);

    Lit findLitByCode(String code);

    List<Lit> findAllLits();

    void deleteLit(Long id);

    List<Lit> findAllByChambre(Long chambreId);

    Long saveServicePartenaire(ServicePartenaire servicePartenaire) throws ReferentielException;

    Long updateServicePartenaire(Long id, ServicePartenaire servicePartenaire) throws ReferentielException;

    ServicePartenaire findServicePartenaireById(Long id);

    ServicePartenaire findServicePartenaireByCode(String code);

    List<ServicePartenaire> findAllServicePartenaires();

    void deleteServicePartenaire(Long id);

    Long saveGroupeSanguin(GroupeSanguin groupeSanguin) throws ReferentielException;

    Long updateGroupeSanguin(Long id, GroupeSanguin groupeSanguin) throws ReferentielException;

    GroupeSanguin findGroupeSanguinById(Long id);

    GroupeSanguin findGroupeSanguinByCode(String code);

    List<GroupeSanguin> findAllGroupeSanguins();

    void deleteGroupeSanguin(Long id);

    TypeDocument saveTypeDocument(TypeDocument typeDocument);

    TypeDocument updateTypeDocument(Long id, TypeDocument typeDocument) throws ReferentielException;

    TypeDocument findTypeDocumentById(Long id);

    List<TypeDocument> findAllTypeDocuments();

    void deleteTypeDocument(Long id);
}
