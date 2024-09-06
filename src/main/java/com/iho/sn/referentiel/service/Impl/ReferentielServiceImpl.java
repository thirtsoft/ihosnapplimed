package com.iho.sn.referentiel.service.Impl;

import com.iho.sn.referentiel.entity.CategoryMedicament;
import com.iho.sn.referentiel.entity.Chambre;
import com.iho.sn.referentiel.entity.GroupeSanguin;
import com.iho.sn.referentiel.entity.Lit;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.entity.ServicePartenaire;
import com.iho.sn.referentiel.entity.TrancheAge;
import com.iho.sn.referentiel.entity.TypeDocument;
import com.iho.sn.referentiel.exception.ReferentielException;
import com.iho.sn.referentiel.repository.CategoryMedicamentRepository;
import com.iho.sn.referentiel.repository.ChambreRepository;
import com.iho.sn.referentiel.repository.GroupeSanguinRepository;
import com.iho.sn.referentiel.repository.LitRepository;
import com.iho.sn.referentiel.repository.MedicamentRepository;
import com.iho.sn.referentiel.repository.ServicePartenaireRepository;
import com.iho.sn.referentiel.repository.TrancheAgeRepository;
import com.iho.sn.referentiel.repository.TypeDocumentRepository;
import com.iho.sn.referentiel.service.ReferentielService;
import com.iho.sn.utils.ConstantSigps;
import com.iho.sn.utils.MessageException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReferentielServiceImpl implements ReferentielService {

    private final CategoryMedicamentRepository categoryMedicamentRepository;

    private final ChambreRepository chambreRepository;

    private final GroupeSanguinRepository groupeSanguinRepository;

    private final LitRepository litRepository;

    private final MedicamentRepository medicamentRepository;

    private final ServicePartenaireRepository servicePartenaireRepository;

    private final TrancheAgeRepository trancheAgeRepository;

    private final TypeDocumentRepository typeDocumentRepository;

    @Override
    public Long saveCategoryMedicament(CategoryMedicament medicament) throws ReferentielException {
        if (medicament == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = medicament.getCode();
        Optional<CategoryMedicament> byCode = categoryMedicamentRepository.findByCode(code);
        if (medicament.getId() == null && byCode.isPresent()
                || (medicament.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(medicament.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre médicament .", code));
        }
        medicament.setActif(true);
        CategoryMedicament savedMedicament = categoryMedicamentRepository.save(medicament);
        return savedMedicament.getId();
    }

    @Override
    public Long updateCategoryMedicament(Long id, CategoryMedicament medicament) throws ReferentielException {
        if (!categoryMedicamentRepository.existsById(id)) {
            throw new ReferentielException("La catégorie de médicament avec l'id " + id + "n'est pas trouvé");
        }
        CategoryMedicament medicamentResult = categoryMedicamentRepository.findCategoryMedicamentById(id);
        if (medicamentResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        medicamentResult.setCode(medicament.getCode());
        medicamentResult.setLibelle(medicament.getLibelle());
        Optional<CategoryMedicament> byCode = categoryMedicamentRepository.findByCode(medicament.getCode());
        if (medicament.getId() == null && byCode.isPresent()
                || (medicament.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(medicament.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre médicament .", medicament.getCode()));
        }
        CategoryMedicament updatedMedicament = categoryMedicamentRepository.save(medicamentResult);
        return updatedMedicament.getId();
    }

    @Override
    public CategoryMedicament findCategoryMedicamentById(Long id) {
        return categoryMedicamentRepository.findById(id).orElseThrow(() -> new ReferentielException("La catégorie medicament avec l'id" + id + "n'est pas trouvé"));
    }


    @Override
    public CategoryMedicament findCategoryMedicamentByCode(String code) {
        return categoryMedicamentRepository.findByCode(code).orElseThrow(() -> new ReferentielException("La catégorie medicament avec le code" + code + "n'est pas trouvé"));
    }

    @Override
    public List<CategoryMedicament> findAllCategoryMedicaments() {
        return categoryMedicamentRepository.findAll();
    }

    @Override
    public void deleteCategoryMedicament(Long id) {
        CategoryMedicament findCategoryMedicament = findCategoryMedicamentById(id);
        findCategoryMedicament.setActif(false);
        categoryMedicamentRepository.save(findCategoryMedicament);
    }

    /************       Médicament   *********************/
    @Override
    public Long saveMedicament(Medicament medicament) throws ReferentielException {
        if (medicament == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = medicament.getCode();
        Optional<Medicament> byCode = medicamentRepository.findByCode(code);
        if (medicament.getId() == null && byCode.isPresent()
                || (medicament.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(medicament.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre médicament .", code));
        }
        medicament.setActif(true);
        Medicament savedMedicament = medicamentRepository.save(medicament);
        return savedMedicament.getId();
    }

    @Override
    public Long updateMedicament(Long id, Medicament medicament) throws ReferentielException {
        if (!medicamentRepository.existsById(id)) {
            throw new ReferentielException("Le Médicament avec l'id " + id + "n'est pas trouvé");
        }
        Medicament medicamentResult = medicamentRepository.findCategoryMedicamentById(id);
        if (medicamentResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        medicamentResult.setCode(medicament.getCode());
        medicamentResult.setLibelle(medicament.getLibelle());
        medicamentResult.setCategoryMedicamentId(medicament.getCategoryMedicamentId());
        Optional<Medicament> byCode = medicamentRepository.findByCode(medicament.getCode());
        if (medicament.getId() == null && byCode.isPresent()
                || (medicament.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(medicament.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre médicament .", medicament.getCode()));
        }
        Medicament updatedMedicament = medicamentRepository.save(medicamentResult);
        return updatedMedicament.getId();
    }

    @Override
    public Medicament findById(Long id) {
        return medicamentRepository.findById(id).orElseThrow(() -> new ReferentielException("Le medicament avec l'id " + id + "n'existe pas"));
    }

    @Override
    public Medicament findByCode(String code) {
        return medicamentRepository.findByCode(code).orElseThrow(() -> new ReferentielException("Le medicament avec le code " + code + "n'existe pas"));
    }

    @Override
    public List<Medicament> findAllMedicaments() {
        return medicamentRepository.findAll();
    }

    @Override
    public void deleteMedicament(Long id) {
        Medicament findMedicament = findById(id);
        findMedicament.setActif(false);
        medicamentRepository.save(findMedicament);

    }

    /************       Chambre   *********************/
    @Override
    public Long saveChambre(Chambre chambre) throws ReferentielException {
        if (chambre == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = chambre.getCode();
        Optional<Chambre> byCode = chambreRepository.findByCode(code);
        if (chambre.getId() == null && byCode.isPresent()
                || (chambre.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(chambre.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à une autre chambre  .", code));
        }
        chambre.setActif(true);
        Chambre savedChambre = chambreRepository.save(chambre);
        return savedChambre.getId();
    }

    @Override
    public Long updateChambre(Long id, Chambre chambre) throws ReferentielException {
        if (!chambreRepository.existsById(id)) {
            throw new ReferentielException("La chambre avec l'id " + id + "n'est pas trouvé");
        }
        Chambre chambreResult = chambreRepository.findChambreById(id);
        if (chambreResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        chambreResult.setCode(chambre.getCode());
        chambreResult.setLibelle(chambre.getLibelle());
        Optional<Chambre> byCode = chambreRepository.findByCode(chambreResult.getCode());
        if (chambreResult.getId() == null && byCode.isPresent()
                || (chambreResult.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(chambreResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à une autre chambre .", chambreResult.getCode()));
        }
        Chambre updatedChambre = chambreRepository.save(chambreResult);
        return updatedChambre.getId();
    }

    @Override
    public Chambre findChambreById(Long id) {
       return chambreRepository.findById(id).orElseThrow(()-> new ReferentielException("La chambre avec l'id " + id + "n'est pas trouvé"));
    }

    @Override
    public Chambre findChambreByCode(String code) {
        return chambreRepository.findByCode(code).orElseThrow(()-> new ReferentielException("La chambre avec le code " + code + "n'est pas trouvé"));
    }

    @Override
    public List<Chambre> findAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public void deleteChambre(Long id) {
        Chambre findChambre = findChambreById(id);
        findChambre.setActif(false);
        chambreRepository.save(findChambre);
    }

    /************       Lit   *********************/
    @Override
    public Long saveLit(Lit lit) throws ReferentielException {
        if (lit == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = lit.getNumero();
        Optional<Lit> byCode = litRepository.findByNumero(code);
        if (lit.getId() == null && byCode.isPresent()
                || (lit.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(lit.getId()))) {
            throw new ReferentielException(String.format("Le numéro de lit %s est déjà associé à un autre lit  .", code));
        }
        lit.setActif(true);
        lit.setEstDisponible(ConstantSigps.DISPONIBLE);
        Lit savedLit = litRepository.save(lit);
        return savedLit.getId();
    }

    @Override
    public Long updateLit(Long id, Lit lit) throws ReferentielException {
        if (!litRepository.existsById(id)) {
            throw new ReferentielException("Le lit avecc l'id " + id + "n'est pas trouvé");
        }
        Lit litResult = litRepository.findLitById(id);
        if (litResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        litResult.setNumero(lit.getNumero());
        litResult.setChambreId(lit.getChambreId());
        litResult.setEstDisponible(lit.getEstDisponible());
        Optional<Lit> byCode = litRepository.findByNumero(litResult.getNumero());
        if (litResult.getId() == null && byCode.isPresent()
                || (litResult.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(litResult.getId()))) {
            throw new ReferentielException(String.format("Le numéro de lit %s est déjà associé à une autre chambre .", litResult.getNumero()));
        }
        Lit updatedLit = litRepository.save(litResult);
        return updatedLit.getId();
    }

    @Override
    public void changerEtatLitAOccupe(Long litId, int etat) {
        if (!litRepository.existsById(litId)) {
            throw new ReferentielException("Le lit avecc l'id " + litId + "n'est pas trouvé");
        }
        Lit litResult = litRepository.findLitById(litId);
        litResult.setEstDisponible(ConstantSigps.OCCUPE);
        litRepository.save(litResult);
    }

    @Override
    public void amenerLitEnreparation(Long litId, int etat) {
        if (!litRepository.existsById(litId)) {
            throw new ReferentielException("Le lit avecc l'id " + litId + "n'est pas trouvé");
        }
        Lit litResult = litRepository.findLitById(litId);
        litResult.setEstDisponible(ConstantSigps.EN_REPARATION);
        litRepository.save(litResult);
    }

    @Override
    public Lit findLitById(Long id) {
        return litRepository.findById(id).orElseThrow(()-> new ReferentielException("Le lit avec l'id" + id + "n'est pas trouvé"));
    }

    @Override
    public Lit findLitByCode(String code) {
        return litRepository.findByNumero(code).orElseThrow(()-> new ReferentielException("Le lit avec le numéro " + code + "n'est pas trouvé"));
    }

    @Override
    public List<Lit> findAllLits() {
        return litRepository.findAll();
    }

    @Override
    public void deleteLit(Long id) {
        Lit findLit = findLitById(id);
        findLit.setActif(false);
        litRepository.save(findLit);
    }

    @Override
    public List<Lit> findAllByChambre(Long chambreId) {
        if (chambreId == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        return litRepository.findAllByChambre(chambreId);
    }

    /************       ServicePartenaire   *********************/
    @Override
    public Long saveServicePartenaire(ServicePartenaire servicePartenaire) throws ReferentielException {
        if (servicePartenaire == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = servicePartenaire.getCode();
        Optional<ServicePartenaire> byCode = servicePartenaireRepository.findByCode(code);
        if (servicePartenaire.getId() == null && byCode.isPresent()
                || (servicePartenaire.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(servicePartenaire.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre service Partenaire  .", code));
        }
        servicePartenaire.setActif(true);
        ServicePartenaire savedServicePartenaire = servicePartenaireRepository.save(servicePartenaire);
        return savedServicePartenaire.getId();
    }

    @Override
    public Long updateServicePartenaire(Long id, ServicePartenaire servicePartenaire) throws ReferentielException {
        if (!servicePartenaireRepository.existsById(id)) {
            throw new ReferentielException("Le ServicePartenaire avecc l'id " + id + "n'est pas trouvé");
        }
        ServicePartenaire servicePartenaireResult = servicePartenaireRepository.findServicePartenaireById(id);
        if (servicePartenaireResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        servicePartenaireResult.setCode(servicePartenaire.getCode());
        servicePartenaireResult.setLibelle(servicePartenaire.getLibelle());
        servicePartenaireResult.setDescription(servicePartenaire.getDescription());
        Optional<ServicePartenaire> byCode = servicePartenaireRepository.findByCode(servicePartenaireResult.getCode());
        if (servicePartenaireResult.getId() == null && byCode.isPresent()
                || (servicePartenaireResult.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(servicePartenaireResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à une autre chambre .", servicePartenaireResult.getCode()));
        }
        ServicePartenaire updatedServicePartenaire = servicePartenaireRepository.save(servicePartenaireResult);
        return updatedServicePartenaire.getId();
    }

    @Override
    public ServicePartenaire findServicePartenaireById(Long id) {
        return servicePartenaireRepository.findById(id).orElseThrow(()-> new ReferentielException("Service partenaire avec l'id " + id + "n'est pas trouvé"));
    }

    @Override
    public ServicePartenaire findServicePartenaireByCode(String code) {
        return servicePartenaireRepository.findByCode(code).orElseThrow(()-> new ReferentielException("Service partenaire avec le code " + code + "n'est pas trouvé"));
    }

    @Override
    public List<ServicePartenaire> findAllServicePartenaires() {
        return servicePartenaireRepository.findAll();
    }

    @Override
    public void deleteServicePartenaire(Long id) {
        ServicePartenaire findServicePartenaire = findServicePartenaireById(id);
        findServicePartenaire.setActif(false);
        servicePartenaireRepository.save(findServicePartenaire);
    }

    /************       Groupe sanguin   *********************/
    @Override
    public Long saveGroupeSanguin(GroupeSanguin groupeSanguin) throws ReferentielException {
        if (groupeSanguin == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = groupeSanguin.getCode();
        Optional<GroupeSanguin> byCode = groupeSanguinRepository.findByCode(code);
        if (groupeSanguin.getId() == null && byCode.isPresent()
                || (groupeSanguin.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(groupeSanguin.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre service Partenaire  .", code));
        }
        groupeSanguin.setActif(true);
        GroupeSanguin savedGroupeSanguin = groupeSanguinRepository.save(groupeSanguin);
        return savedGroupeSanguin.getId();
    }

    @Override
    public Long updateGroupeSanguin(Long id, GroupeSanguin groupeSanguin) throws ReferentielException {
        if (!groupeSanguinRepository.existsById(id)) {
            throw new ReferentielException("Le Groupe sanguin avecc l'id " + id + "n'est pas trouvé");
        }
        GroupeSanguin groupeSanguinResult = groupeSanguinRepository.findGroupeSanguinById(id);
        if (groupeSanguinResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        groupeSanguinResult.setCode(groupeSanguin.getCode());
        groupeSanguinResult.setDescription(groupeSanguin.getDescription());
        Optional<GroupeSanguin> byCode = groupeSanguinRepository.findByCode(groupeSanguinResult.getCode());
        if (groupeSanguinResult.getId() == null && byCode.isPresent()
                || (groupeSanguinResult.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(groupeSanguinResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre groupe sanguin .", groupeSanguinResult.getCode()));
        }
        GroupeSanguin updatedGroupeSanguin = groupeSanguinRepository.save(groupeSanguinResult);
        return updatedGroupeSanguin.getId();
    }

    @Override
    public GroupeSanguin findGroupeSanguinById(Long id) {
        return groupeSanguinRepository.findById(id).orElseThrow(()-> new ReferentielException("Groupe sanguin avec l'id " + id + "n'est pas trouvé"));
    }

    @Override
    public GroupeSanguin findGroupeSanguinByCode(String code) {
        return groupeSanguinRepository.findByCode(code).orElseThrow(()-> new ReferentielException("Groupe sanguin avec le code " + code + "n'est pas trouvé"));
    }

    @Override
    public List<GroupeSanguin> findAllGroupeSanguins() {
        return groupeSanguinRepository.findAll();
    }

    @Override
    public void deleteGroupeSanguin(Long id) {
        GroupeSanguin findGroupeSanguin = findGroupeSanguinById(id);
        findGroupeSanguin.setActif(false);
        groupeSanguinRepository.save(findGroupeSanguin);
    }

    /************       Tranche d'age   *********************/
    @Override
    public Long saveTrancheAge(TrancheAge trancheAge) throws ReferentielException {
        if (trancheAge == null)
            throw new ReferentielException(MessageException.NULL_OBJECT);
        String code = trancheAge.getCode();
        Optional<TrancheAge> byCode = trancheAgeRepository.findByCode(code);
        if (trancheAge.getId() == null && byCode.isPresent()
                || (trancheAge.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(trancheAge.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à une autre tranche d'age  .", code));
        }
        trancheAge.setActif(true);
        TrancheAge savedTrancheAge = trancheAgeRepository.save(trancheAge);
        return savedTrancheAge.getId();
    }

    @Override
    public Long updateTrancheAge(Long id, TrancheAge trancheAge) throws ReferentielException {
        if (!trancheAgeRepository.existsById(id)) {
            throw new ReferentielException("La Tranche d'Age avecc l'id " + id + "n'est pas trouvé");
        }
        TrancheAge trancheAgeResult = trancheAgeRepository.findTrancheAgeById(id);
        if (trancheAgeResult == null) {
            throw new ReferentielException(MessageException.NOT_FOUND_OBJECT);
        }
        trancheAgeResult.setCode(trancheAge.getCode());
        trancheAgeResult.setLibelle(trancheAge.getLibelle());
        Optional<TrancheAge> byCode = trancheAgeRepository.findByCode(trancheAgeResult.getCode());
        if (trancheAgeResult.getId() == null && byCode.isPresent()
                || (trancheAgeResult.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(trancheAgeResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à une autre tranche d'age .", trancheAgeResult.getCode()));
        }
        TrancheAge updatedTrancheAge = trancheAgeRepository.save(trancheAgeResult);
        return updatedTrancheAge.getId();
    }

    @Override
    public TrancheAge findTrancheAgeById(Long id) {
        return trancheAgeRepository.findById(id).orElseThrow(()-> new ReferentielException("La Tranche d'Age avec l'id " + id + "n'est pas trouvé"));
    }

    @Override
    public TrancheAge findTrancheAgeByCode(String code) {
        return trancheAgeRepository.findByCode(code).orElseThrow(()-> new ReferentielException("La Tranche d'Age avec le code " + code + "n'est pas trouvé"));
    }

    @Override
    public List<TrancheAge> findAllTrancheAges() {
        return trancheAgeRepository.findAll();
    }

    @Override
    public void deleteTrancheAge(Long id) {
        TrancheAge findTrancheAge = findTrancheAgeById(id);
        findTrancheAge.setActif(false);
        trancheAgeRepository.save(findTrancheAge);
    }

    /***************   TypeDocument   *********************/
    @Override
    public TypeDocument saveTypeDocument(TypeDocument typeDocument) {
        if (typeDocument == null)
            throw new ReferentielException("L'objet à sauvegarder est null");
        if (typeDocument.getCode() == null || typeDocument.getCode().isEmpty())
            throw new ReferentielException("Le code du type de document est obligatoire ");
        if (typeDocument.getLibelle() == null || typeDocument.getLibelle().isEmpty())
            throw new ReferentielException("Le libellé du type de document est obligatoire");
        TypeDocument byCode = typeDocumentRepository.findTypeDocumentByCode(typeDocument.getCode());
        if (typeDocument.getId() == null && byCode != null
                || (typeDocument.getId() != null && byCode != null && !byCode.getId().equals(typeDocument.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre type de document .", typeDocument.getCode()));
        }
        typeDocument.setActif(true);
        typeDocumentRepository.save(typeDocument);
        return typeDocument;
    }

    @Override
    public TypeDocument updateTypeDocument(Long id, TypeDocument typeDocument) throws ReferentielException {
        TypeDocument foundTypeDocument = findTypeDocumentById(id);
        if (foundTypeDocument == null)
            throw new ReferentielException("L'object à modifier n'est pas trouvé pas");
        typeDocument.setId(id);
        saveTypeDocument(typeDocument);
        return typeDocument;
    }

    @Override
    public TypeDocument findTypeDocumentById(Long id) {
        return typeDocumentRepository.findTypeDocumentById(id);
    }

    @Override
    public List<TypeDocument> findAllTypeDocuments() {
        return typeDocumentRepository.findAll();
    }

    @Override
    public void deleteTypeDocument(Long id) {
        TypeDocument deleted = typeDocumentRepository.findTypeDocumentById(id);
        deleted.setActif(false);
        typeDocumentRepository.save(deleted);
    }
}
