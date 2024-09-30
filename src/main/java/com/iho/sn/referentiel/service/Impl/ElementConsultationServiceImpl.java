package com.iho.sn.referentiel.service.Impl;

import com.iho.sn.message.Message;
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
import com.iho.sn.referentiel.entity.SousElementDermatoseInf;
import com.iho.sn.referentiel.entity.SousElementHypothese;
import com.iho.sn.referentiel.exception.ReferentielException;
import com.iho.sn.referentiel.repository.DermatoseAutoimineRepository;
import com.iho.sn.referentiel.repository.DermatoseBulleuseRepository;
import com.iho.sn.referentiel.repository.DermatoseInfBacterienneRepository;
import com.iho.sn.referentiel.repository.DermatoseInfViraleRepository;
import com.iho.sn.referentiel.repository.DermatoseInfectieuseRepository;
import com.iho.sn.referentiel.repository.DermatoseInflammatoireRepository;
import com.iho.sn.referentiel.repository.ElementExamenDermatologiqueRepository;
import com.iho.sn.referentiel.repository.ElementHypotheseRepository;
import com.iho.sn.referentiel.repository.ElementPlainteRepository;
import com.iho.sn.referentiel.repository.ElementRechercheNotionRepository;
import com.iho.sn.referentiel.repository.ElementTerrainRepository;
import com.iho.sn.referentiel.repository.SousElementDermatoseInfRepository;
import com.iho.sn.referentiel.repository.SousElementHypotheseRepository;
import com.iho.sn.referentiel.service.ElementConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@RequiredArgsConstructor
public class ElementConsultationServiceImpl implements ElementConsultationService {

    private final DermatoseAutoimineRepository dermatoseAutoimineRepository;
    private final DermatoseBulleuseRepository dermatoseBulleuseRepository;
    private final DermatoseInfBacterienneRepository dermatoseInfBacterienneRepository;
    private final DermatoseInfectieuseRepository dermatoseInfectieuseRepository;
    private final DermatoseInflammatoireRepository dermatoseInflammatoireRepository;
    private final DermatoseInfViraleRepository dermatoseInfViraleRepository;
    private final ElementExamenDermatologiqueRepository elementExamenDermatologiqueRepository;
    private final ElementHypotheseRepository elementHypotheseRepository;
    private final ElementPlainteRepository elementPlainteRepository;
    private final ElementRechercheNotionRepository elementRechercheNotionRepository;
    private final ElementTerrainRepository elementTerrainRepository;
    private final SousElementHypotheseRepository sousElementHypotheseRepository;
    private final SousElementDermatoseInfRepository sousElementDermatoseInfRepository;

    @Override
    public void saveDermatoseAutoimine(DermatoseAutoimine dermatoseAutoimine) throws ReferentielException {
        if (dermatoseAutoimine == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseAutoimine.getLibelle() == null || isBlank(dermatoseAutoimine.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseAutoimine.getLibelle();
        DermatoseAutoimine byLibelle = dermatoseAutoimineRepository.findByLibelle(libelle);
        if (dermatoseAutoimine.getId() == null && byLibelle != null
                || (dermatoseAutoimine.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseAutoimine.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseAutoimine .", libelle));
        }
        dermatoseAutoimine.setActif(true);
        dermatoseAutoimineRepository.save(dermatoseAutoimine);
    }

    @Override
    public Long updateDermatoseAutoimine(Long id, DermatoseAutoimine dermatoseAutoimine) throws ReferentielException {
        if (!dermatoseAutoimineRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseAutoimine avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseAutoimine dermatoseAutoimineResult = dermatoseAutoimineRepository.findDermatoseAutoimineById(id);
        if (dermatoseAutoimineResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseAutoimineResult.setActif(dermatoseAutoimine.isActif());
        dermatoseAutoimineResult.setLibelle(dermatoseAutoimine.getLibelle());
        String libelle = dermatoseAutoimine.getLibelle();
        DermatoseAutoimine byLibelle = dermatoseAutoimineRepository.findByLibelle(libelle);
        if (dermatoseAutoimine.getId() == null && byLibelle != null
                || (dermatoseAutoimine.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseAutoimine.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseAutoimine .", libelle));
        }
        DermatoseAutoimine updatedDermatoseAutoimine = dermatoseAutoimineRepository.save(dermatoseAutoimineResult);
        return updatedDermatoseAutoimine.getId();
    }

    @Override
    public DermatoseAutoimine findDermatoseAutoimineById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseAutoimineRepository.findDermatoseAutoimineById(id);
    }

    @Override
    public DermatoseAutoimine findDermatoseAutoimineByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseAutoimineRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseAutoimine> findAllDermatoseAutoimines() {
        return dermatoseAutoimineRepository.findAll();
    }

    @Override
    public void deleteDermatoseAutoimine(Long id) {
        DermatoseAutoimine deleted = dermatoseAutoimineRepository.findDermatoseAutoimineById(id);
        deleted.setActif(false);
        dermatoseAutoimineRepository.save(deleted);
    }

    @Override
    public void saveDermatoseBulleuse(DermatoseBulleuse dermatoseBulleuse) throws ReferentielException {
        if (dermatoseBulleuse == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseBulleuse.getLibelle() == null || isBlank(dermatoseBulleuse.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseBulleuse.getLibelle();
        DermatoseBulleuse byLibelle = dermatoseBulleuseRepository.findByLibelle(libelle);
        if (dermatoseBulleuse.getId() == null && byLibelle != null
                || (dermatoseBulleuse.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseBulleuse.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseBulleuse .", libelle));
        }
        dermatoseBulleuse.setActif(true);
        dermatoseBulleuseRepository.save(dermatoseBulleuse);
    }

    @Override
    public void updateDermatoseBulleuse(Long id, DermatoseBulleuse dermatoseBulleuse) throws ReferentielException {
        if (!dermatoseBulleuseRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseBulleuse avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseBulleuse dermatoseAutoimineResult = dermatoseBulleuseRepository.findDermatoseBulleuseById(id);
        if (dermatoseAutoimineResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseAutoimineResult.setActif(dermatoseBulleuse.isActif());
        dermatoseAutoimineResult.setLibelle(dermatoseBulleuse.getLibelle());
        String libelle = dermatoseBulleuse.getLibelle();
        DermatoseAutoimine byLibelle = dermatoseAutoimineRepository.findByLibelle(libelle);
        if (dermatoseBulleuse.getId() == null && byLibelle != null
                || (dermatoseBulleuse.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseBulleuse.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseBulleuse .", libelle));
        }
        dermatoseBulleuseRepository.save(dermatoseAutoimineResult);
    }

    @Override
    public DermatoseBulleuse findDermatoseBulleuseById(Long id) {
        return dermatoseBulleuseRepository.findDermatoseBulleuseById(id);
    }

    @Override
    public DermatoseBulleuse findDermatoseBulleuseByLibelle(String libelle) {
        return dermatoseBulleuseRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseBulleuse> findAllDermatoseBulleuses() {
        return dermatoseBulleuseRepository.findAll();
    }

    @Override
    public void deleteDermatoseBulleuse(Long id) {
        DermatoseBulleuse deleted = dermatoseBulleuseRepository.findDermatoseBulleuseById(id);
        deleted.setActif(false);
        dermatoseBulleuseRepository.save(deleted);
    }

    @Override
    public void saveDermatoseInfBacterienne(DermatoseInfBacterienne dermatoseInfBacterienne) throws ReferentielException {
        if (dermatoseInfBacterienne == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseInfBacterienne.getLibelle() == null || isBlank(dermatoseInfBacterienne.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseInfBacterienne.getLibelle();
        DermatoseInfBacterienne byLibelle = dermatoseInfBacterienneRepository.findByLibelle(libelle);
        if (dermatoseInfBacterienne.getId() == null && byLibelle != null
                || (dermatoseInfBacterienne.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfBacterienne.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseBulleuse .", libelle));
        }
        dermatoseInfBacterienne.setActif(true);
        dermatoseInfBacterienneRepository.save(dermatoseInfBacterienne);
    }

    @Override
    public void updateDermatoseInfBacterienne(Long id, DermatoseInfBacterienne dermatoseInfBacterienne) throws ReferentielException {
        if (!dermatoseInfBacterienneRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseInfBacterienne avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseInfBacterienne dermatoseInfBacterienneResult = dermatoseInfBacterienneRepository.findDermatoseInfBacterienneById(id);
        if (dermatoseInfBacterienneResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseInfBacterienneResult.setActif(dermatoseInfBacterienne.isActif());
        dermatoseInfBacterienneResult.setLibelle(dermatoseInfBacterienne.getLibelle());
        String libelle = dermatoseInfBacterienne.getLibelle();
        DermatoseInfBacterienne byLibelle = dermatoseInfBacterienneRepository.findByLibelle(libelle);
        if (dermatoseInfBacterienne.getId() == null && byLibelle != null
                || (dermatoseInfBacterienne.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfBacterienne.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfBacterienne .", libelle));
        }
        dermatoseInfBacterienneRepository.save(dermatoseInfBacterienne);
    }

    @Override
    public DermatoseInfBacterienne findDermatoseInfBacterienneById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfBacterienneRepository.findDermatoseInfBacterienneById(id);
    }

    @Override
    public DermatoseInfBacterienne findDermatoseInfBacterienneByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfBacterienneRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseInfBacterienne> findAllDermatoseInfBacteriennes() {
        return dermatoseInfBacterienneRepository.findAll();
    }

    @Override
    public void deleteDermatoseInfBacterienne(Long id) {
        DermatoseInfBacterienne deleted = dermatoseInfBacterienneRepository.findDermatoseInfBacterienneById(id);
        deleted.setActif(false);
        dermatoseInfBacterienneRepository.save(deleted);
    }

    @Override
    public void saveDermatoseInfectieuse(DermatoseInfectieuse dermatoseInfectieuse) throws ReferentielException {
        if (dermatoseInfectieuse == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseInfectieuse.getLibelle() == null || isBlank(dermatoseInfectieuse.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseInfectieuse.getLibelle();
        DermatoseInfectieuse byLibelle = dermatoseInfectieuseRepository.findByLibelle(libelle);
        if (dermatoseInfectieuse.getId() == null && byLibelle != null
                || (dermatoseInfectieuse.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfectieuse.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfectieuse .", libelle));
        }
        dermatoseInfectieuse.setActif(true);
        dermatoseInfectieuseRepository.save(dermatoseInfectieuse);
    }

    @Override
    public void updateDermatoseInfectieuse(Long id, DermatoseInfectieuse dermatoseInfectieuse) throws ReferentielException {
        if (!dermatoseInfectieuseRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseInfectieuse avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseInfectieuse dermatoseInfectieuseResult = dermatoseInfectieuseRepository.findDermatoseInfectieuseById(id);
        if (dermatoseInfectieuseResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseInfectieuseResult.setActif(dermatoseInfectieuse.isActif());
        dermatoseInfectieuseResult.setLibelle(dermatoseInfectieuse.getLibelle());
        String libelle = dermatoseInfectieuse.getLibelle();
        DermatoseInfectieuse byLibelle = dermatoseInfectieuseRepository.findByLibelle(libelle);
        if (dermatoseInfectieuse.getId() == null && byLibelle != null
                || (dermatoseInfectieuse.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfectieuse.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfectieuse .", libelle));
        }
        dermatoseInfectieuseRepository.save(dermatoseInfectieuse);
    }

    @Override
    public DermatoseInfectieuse findDermatoseInfectieuseById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfectieuseRepository.findDermatoseInfectieuseById(id);
    }

    @Override
    public DermatoseInfectieuse findDermatoseInfectieuseByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfectieuseRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseInfectieuse> findAllDermatoseInfectieuses() {
        return dermatoseInfectieuseRepository.findAll();
    }

    @Override
    public void deleteDermatoseInfectieuse(Long id) {
        DermatoseInfectieuse deleted = dermatoseInfectieuseRepository.findDermatoseInfectieuseById(id);
        deleted.setActif(false);
        dermatoseInfectieuseRepository.save(deleted);
    }

    @Override
    public Long saveDermatoseInflammatoire(DermatoseInflammatoire dermatoseInflammatoire) throws ReferentielException {
        if (dermatoseInflammatoire == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseInflammatoire.getLibelle() == null || isBlank(dermatoseInflammatoire.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseInflammatoire.getLibelle();
        DermatoseInflammatoire byLibelle = dermatoseInflammatoireRepository.findByLibelle(libelle);
        if (dermatoseInflammatoire.getId() == null && byLibelle != null
                || (dermatoseInflammatoire.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInflammatoire.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInflammatoire .", libelle));
        }
        dermatoseInflammatoire.setActif(true);
        DermatoseInflammatoire saved = dermatoseInflammatoireRepository.save(dermatoseInflammatoire);
        return saved.getId();
    }

    @Override
    public Long updateDermatoseInflammatoire(Long id, DermatoseInflammatoire dermatoseInflammatoire) throws ReferentielException {
        if (!dermatoseInflammatoireRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseInflammatoire avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseInflammatoire dermatoseInflammatoireResult = dermatoseInflammatoireRepository.findDermatoseInflammatoireById(id);
        if (dermatoseInflammatoireResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseInflammatoireResult.setActif(dermatoseInflammatoire.isActif());
        dermatoseInflammatoireResult.setLibelle(dermatoseInflammatoire.getLibelle());
        String libelle = dermatoseInflammatoire.getLibelle();
        DermatoseInflammatoire byLibelle = dermatoseInflammatoireRepository.findByLibelle(libelle);
        if (dermatoseInflammatoire.getId() == null && byLibelle != null
                || (dermatoseInflammatoire.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInflammatoire.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfectieuse .", libelle));
        }
        DermatoseInflammatoire updated = dermatoseInflammatoireRepository.save(dermatoseInflammatoireResult);
        return updated.getId();
    }

    @Override
    public DermatoseInflammatoire findDermatoseInflammatoireById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInflammatoireRepository.findDermatoseInflammatoireById(id);
    }

    @Override
    public DermatoseInflammatoire findDermatoseInflammatoireByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInflammatoireRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseInflammatoire> findAllDermatoseInflammatoires() {
        return dermatoseInflammatoireRepository.findAll();
    }

    @Override
    public void deleteDermatoseInflammatoire(Long id) {
        DermatoseInflammatoire deleted = dermatoseInflammatoireRepository.findDermatoseInflammatoireById(id);
        deleted.setActif(false);
        dermatoseInflammatoireRepository.save(deleted);

    }

    @Override
    public Long saveDermatoseInfVirale(DermatoseInfVirale dermatoseInfVirale) throws ReferentielException {
        if (dermatoseInfVirale == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (dermatoseInfVirale.getLibelle() == null || isBlank(dermatoseInfVirale.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = dermatoseInfVirale.getLibelle();
        DermatoseInfVirale byLibelle = dermatoseInfViraleRepository.findByLibelle(libelle);
        if (dermatoseInfVirale.getId() == null && byLibelle != null
                || (dermatoseInfVirale.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfVirale.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfVirale .", libelle));
        }
        dermatoseInfVirale.setActif(true);
        DermatoseInfVirale saved = dermatoseInfViraleRepository.save(dermatoseInfVirale);
        return saved.getId();
    }

    @Override
    public Long updateDermatoseInfVirale(Long id, DermatoseInfVirale dermatoseInfVirale) throws ReferentielException {
        if (!dermatoseInfViraleRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseInfVirale avec l'id " + id + "n'est pas trouvé");
        }
        DermatoseInfVirale dermatoseInfViraleResult = dermatoseInfViraleRepository.findDermatoseInfViraleById(id);
        if (dermatoseInfViraleResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        dermatoseInfViraleResult.setActif(dermatoseInfVirale.isActif());
        dermatoseInfViraleResult.setLibelle(dermatoseInfVirale.getLibelle());
        String libelle = dermatoseInfViraleResult.getLibelle();
        DermatoseInfVirale byLibelle = dermatoseInfViraleRepository.findByLibelle(libelle);
        if (dermatoseInfVirale.getId() == null && byLibelle != null
                || (dermatoseInfVirale.getId() != null && byLibelle != null && !byLibelle.getId().equals(dermatoseInfVirale.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre DermatoseInfVirale .", libelle));
        }
        DermatoseInfVirale updated = dermatoseInfViraleRepository.save(dermatoseInfViraleResult);
        return updated.getId();
    }

    @Override
    public DermatoseInfVirale findDermatoseInfViraleById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfViraleRepository.findDermatoseInfViraleById(id);
    }

    @Override
    public DermatoseInfVirale findDermatoseInfViraleByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return dermatoseInfViraleRepository.findByLibelle(libelle);
    }

    @Override
    public List<DermatoseInfVirale> findAllDermatoseInfVirales() {
        return dermatoseInfViraleRepository.findAll();
    }

    @Override
    public void deleteDermatoseInfVirale(Long id) {
        DermatoseInfVirale deleted = dermatoseInfViraleRepository.findDermatoseInfViraleById(id);
        deleted.setActif(false);
        dermatoseInfViraleRepository.save(deleted);
    }

    @Override
    public Long saveElementExamenDermatologique(ElementExamenDermatologique elementExamenDermatologique) throws ReferentielException {
        if (elementExamenDermatologique == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (elementExamenDermatologique.getLibelle() == null || isBlank(elementExamenDermatologique.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = elementExamenDermatologique.getLibelle();
        ElementExamenDermatologique byLibelle = elementExamenDermatologiqueRepository.findByLibelle(libelle);
        if (elementExamenDermatologique.getId() == null && byLibelle != null
                || (elementExamenDermatologique.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementExamenDermatologique.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementExamenDermatologique .", libelle));
        }
        elementExamenDermatologique.setActif(true);
        ElementExamenDermatologique saved = elementExamenDermatologiqueRepository.save(elementExamenDermatologique);
        return saved.getId();
    }

    @Override
    public Long updateElementExamenDermatologique(Long id, ElementExamenDermatologique elementExamenDermatologique) throws ReferentielException {
        if (!elementExamenDermatologiqueRepository.existsById(id)) {
            throw new ReferentielException("La DermatoseInfVirale avec l'id " + id + "n'est pas trouvé");
        }
        ElementExamenDermatologique elementExamenDermatologiqueResult = elementExamenDermatologiqueRepository.findElementExamenDermatologiqueById(id);
        if (elementExamenDermatologiqueResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        elementExamenDermatologiqueResult.setActif(elementExamenDermatologique.isActif());
        elementExamenDermatologiqueResult.setLibelle(elementExamenDermatologique.getLibelle());
        String libelle = elementExamenDermatologiqueResult.getLibelle();
        ElementExamenDermatologique byLibelle = elementExamenDermatologiqueRepository.findByLibelle(libelle);
        if (elementExamenDermatologique.getId() == null && byLibelle != null
                || (elementExamenDermatologique.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementExamenDermatologique.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementExamenDermatologique .", libelle));
        }
        return saveElementExamenDermatologique(elementExamenDermatologiqueResult);
    }

    @Override
    public ElementExamenDermatologique findElementExamenDermatologiqueById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementExamenDermatologiqueRepository.findElementExamenDermatologiqueById(id);
    }

    @Override
    public ElementExamenDermatologique findElementExamenDermatologiqueByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementExamenDermatologiqueRepository.findByLibelle(libelle);
    }

    @Override
    public List<ElementExamenDermatologique> findAllElementExamenDermatologiques() {
        return elementExamenDermatologiqueRepository.findAll();
    }

    @Override
    public void deleteElementExamenDermatologique(Long id) {
        ElementExamenDermatologique deleted = elementExamenDermatologiqueRepository.findElementExamenDermatologiqueById(id);
        deleted.setActif(false);
        elementExamenDermatologiqueRepository.save(deleted);

    }

    @Override
    public Long saveElementHypothese(ElementHypothese elementHypothese) throws ReferentielException {
        if (elementHypothese == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (elementHypothese.getLibelle() == null || isBlank(elementHypothese.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = elementHypothese.getLibelle();
        ElementHypothese byLibelle = elementHypotheseRepository.findByLibelle(libelle);
        if (elementHypothese.getId() == null && byLibelle != null
                || (elementHypothese.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementHypothese.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementHypothese .", libelle));
        }
        elementHypothese.setActif(true);
        ElementHypothese saved = elementHypotheseRepository.save(elementHypothese);
        return saved.getId();
    }

    @Override
    public Long updateElementHypothese(Long id, ElementHypothese elementHypothese) throws ReferentielException {
        if (!elementHypotheseRepository.existsById(id)) {
            throw new ReferentielException("La ElementHypothese avec l'id " + id + "n'est pas trouvé");
        }
        ElementHypothese elementHypotheseResult = elementHypotheseRepository.findElementHypotheseById(id);
        if (elementHypotheseResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        elementHypotheseResult.setActif(elementHypothese.isActif());
        elementHypotheseResult.setLibelle(elementHypothese.getLibelle());
        String libelle = elementHypotheseResult.getLibelle();
        ElementHypothese byLibelle = elementHypotheseRepository.findByLibelle(libelle);
        if (elementHypotheseResult.getId() == null && byLibelle != null
                || (elementHypotheseResult.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementHypotheseResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementHypothese .", libelle));
        }
        ElementHypothese updated = elementHypotheseRepository.save(elementHypotheseResult);
        return updated.getId();
    }

    @Override
    public ElementHypothese findElementHypotheseById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementHypotheseRepository.findElementHypotheseById(id);
    }

    @Override
    public SousElementHypothese findSousElementHypotheseById(Long id) {
        if (id == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        return sousElementHypotheseRepository.findSousElementHypotheseById(id);
    }

    @Override
    public SousElementDermatoseInf findSousElementDermatoseInfById(Long id) {
        if (id == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        return sousElementDermatoseInfRepository.findSousElementDermatoseInfById(id);
    }

    @Override
    public ElementHypothese findElementHypotheseByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementHypotheseRepository.findByLibelle(libelle);
    }

    @Override
    public List<ElementHypothese> findAllElementHypotheses() {
        return elementHypotheseRepository.findAll();
    }

    @Override
    public void deleteElementHypothese(Long id) {
        ElementHypothese deleted = elementHypotheseRepository.findElementHypotheseById(id);
        deleted.setActif(false);
        elementHypotheseRepository.save(deleted);
    }

    @Override
    public Long saveElementPlainte(ElementPlainte elementPlainte) throws ReferentielException {
        if (elementPlainte == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (elementPlainte.getLibelle() == null || isBlank(elementPlainte.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = elementPlainte.getLibelle();
        ElementPlainte byLibelle = elementPlainteRepository.findByLibelle(libelle);
        if (elementPlainte.getId() == null && byLibelle != null
                || (elementPlainte.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementPlainte.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementPlainte .", libelle));
        }
        elementPlainte.setActif(true);
        ElementPlainte saved = elementPlainteRepository.save(elementPlainte);
        return saved.getId();
    }

    @Override
    public Long updateElementPlainte(Long id, ElementPlainte elementPlainte) throws ReferentielException {
        if (!elementPlainteRepository.existsById(id)) {
            throw new ReferentielException("La ElementPlainte avec l'id " + id + "n'est pas trouvé");
        }
        ElementPlainte elementPlainteResult = elementPlainteRepository.findElementPlainteById(id);
        if (elementPlainteResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        elementPlainteResult.setActif(elementPlainte.isActif());
        elementPlainteResult.setLibelle(elementPlainte.getLibelle());
        String libelle = elementPlainteResult.getLibelle();
        ElementPlainte byLibelle = elementPlainteRepository.findByLibelle(libelle);
        if (elementPlainteResult.getId() == null && byLibelle != null
                || (elementPlainteResult.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementPlainteResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementPlainte .", libelle));
        }
        ElementPlainte updated = elementPlainteRepository.save(elementPlainteResult);
        return updated.getId();
    }

    @Override
    public ElementPlainte findElementPlainteById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementPlainteRepository.findElementPlainteById(id);
    }

    @Override
    public ElementPlainte findElementPlainteByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementPlainteRepository.findByLibelle(libelle);
    }

    @Override
    public List<ElementPlainte> findAllElementPlaintes() {
        return elementPlainteRepository.findAll();
    }

    @Override
    public void deleteElementPlainte(Long id) {
        ElementPlainte deleted = elementPlainteRepository.findElementPlainteById(id);
        deleted.setActif(false);
        elementPlainteRepository.save(deleted);
    }

    @Override
    public Long saveElementRechercheNotion(ElementRechercheNotion elementRechercheNotion) throws ReferentielException {
        if (elementRechercheNotion == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (elementRechercheNotion.getLibelle() == null || isBlank(elementRechercheNotion.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = elementRechercheNotion.getLibelle();
        ElementRechercheNotion byLibelle = elementRechercheNotionRepository.findByLibelle(libelle);
        if (elementRechercheNotion.getId() == null && byLibelle != null
                || (elementRechercheNotion.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementRechercheNotion.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementRechercheNotion .", libelle));
        }
        elementRechercheNotion.setActif(true);
        ElementRechercheNotion saved = elementRechercheNotionRepository.save(elementRechercheNotion);
        return saved.getId();
    }

    @Override
    public Long updateElementRechercheNotion(Long id, ElementRechercheNotion elementRechercheNotion) throws ReferentielException {
        if (!elementRechercheNotionRepository.existsById(id)) {
            throw new ReferentielException("La ElementRechercheNotion avec l'id " + id + "n'est pas trouvé");
        }
        ElementRechercheNotion elementRechercheNotionResult = elementRechercheNotionRepository.findElementRechercheNotionById(id);
        if (elementRechercheNotionResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        elementRechercheNotionResult.setActif(elementRechercheNotion.isActif());
        elementRechercheNotionResult.setLibelle(elementRechercheNotion.getLibelle());
        String libelle = elementRechercheNotionResult.getLibelle();
        ElementRechercheNotion byLibelle = elementRechercheNotionRepository.findByLibelle(libelle);
        if (elementRechercheNotionResult.getId() == null && byLibelle != null
                || (elementRechercheNotionResult.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementRechercheNotionResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementRechercheNotion .", libelle));
        }
        ElementRechercheNotion updated = elementRechercheNotionRepository.save(elementRechercheNotionResult);
        return updated.getId();
    }

    @Override
    public ElementRechercheNotion findElementRechercheNotionById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementRechercheNotionRepository.findElementRechercheNotionById(id);
    }

    @Override
    public ElementRechercheNotion findElementRechercheNotionByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementRechercheNotionRepository.findByLibelle(libelle);
    }

    @Override
    public List<ElementRechercheNotion> findAllElementRechercheNotions() {
        return elementRechercheNotionRepository.findAll();
    }

    @Override
    public void deleteElementRechercheNotion(Long id) {
        ElementRechercheNotion deleted = elementRechercheNotionRepository.findElementRechercheNotionById(id);
        deleted.setActif(false);
        elementRechercheNotionRepository.save(deleted);
    }

    @Override
    public Long saveElementTerrain(ElementTerrain elementTerrain) throws ReferentielException {
        if (elementTerrain == null)
            throw new ReferentielException(Message.NULL_OBJECT);
        if (elementTerrain.getLibelle() == null || isBlank(elementTerrain.getLibelle()))
            throw new ReferentielException("Le libelle est obligatoire");
        String libelle = elementTerrain.getLibelle();
        ElementTerrain byLibelle = elementTerrainRepository.findByLibelle(libelle);
        if (elementTerrain.getId() == null && byLibelle != null
                || (elementTerrain.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementTerrain.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementTerrain .", libelle));
        }
        elementTerrain.setActif(true);
        ElementTerrain saved = elementTerrainRepository.save(elementTerrain);
        return saved.getId();
    }

    @Override
    public Long updateElementTerrain(Long id, ElementTerrain elementTerrain) throws ReferentielException {
        if (!elementTerrainRepository.existsById(id)) {
            throw new ReferentielException("La ElementTerrain avec l'id " + id + "n'est pas trouvé");
        }
        ElementTerrain elementTerrainResult = elementTerrainRepository.findElementTerrainById(id);
        if (elementTerrainResult == null) {
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        }
        elementTerrainResult.setActif(elementTerrain.isActif());
        elementTerrainResult.setLibelle(elementTerrain.getLibelle());
        String libelle = elementTerrainResult.getLibelle();
        ElementTerrain byLibelle = elementTerrainRepository.findByLibelle(libelle);
        if (elementTerrainResult.getId() == null && byLibelle != null
                || (elementTerrainResult.getId() != null && byLibelle != null && !byLibelle.getId().equals(elementTerrainResult.getId()))) {
            throw new ReferentielException(String.format("Le code %s est déjà associé à un autre ElementTerrain .", libelle));
        }
        ElementTerrain updated = elementTerrainRepository.save(elementTerrainResult);
        return updated.getId();
    }

    @Override
    public ElementTerrain findElementTerrainById(Long id) {
        if (id == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementTerrainRepository.findElementTerrainById(id);
    }

    @Override
    public ElementTerrain findElementTerrainByLibelle(String libelle) {
        if (libelle == null)
            throw new ReferentielException(Message.NOT_FOUND_OBJECT);
        return elementTerrainRepository.findByLibelle(libelle);
    }

    @Override
    public List<ElementTerrain> findAllElementTerrains() {
        return elementTerrainRepository.findAll();
    }

    @Override
    public void deleteElementTerrain(Long id) {
        ElementTerrain deleted = elementTerrainRepository.findElementTerrainById(id);
        deleted.setActif(false);
        elementTerrainRepository.save(deleted);
    }
}
