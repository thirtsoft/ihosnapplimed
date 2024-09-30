package com.iho.sn.referentiel.service;

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

import java.util.List;

public interface ElementConsultationService {

    void saveDermatoseAutoimine(DermatoseAutoimine dermatoseAutoimine) throws ReferentielException;

    Long updateDermatoseAutoimine(Long id, DermatoseAutoimine dermatoseAutoimine) throws ReferentielException;

    DermatoseAutoimine findDermatoseAutoimineById(Long id);

    DermatoseAutoimine findDermatoseAutoimineByLibelle(String libelle);

    List<DermatoseAutoimine> findAllDermatoseAutoimines();

    void deleteDermatoseAutoimine(Long id);

    /************   Dermatose Bulleuse  **************/

    void saveDermatoseBulleuse(DermatoseBulleuse dermatoseBulleuse) throws ReferentielException;

    void updateDermatoseBulleuse(Long id, DermatoseBulleuse dermatoseBulleuse) throws ReferentielException;

    DermatoseBulleuse findDermatoseBulleuseById(Long id);

    DermatoseBulleuse findDermatoseBulleuseByLibelle(String libelle);

    List<DermatoseBulleuse> findAllDermatoseBulleuses();

    void deleteDermatoseBulleuse(Long id);

    /***********           DermatoseInfBacteriene ***********/
    void saveDermatoseInfBacterienne(DermatoseInfBacterienne dermatoseInfBacterienne) throws ReferentielException;

    void updateDermatoseInfBacterienne(Long id, DermatoseInfBacterienne dermatoseInfBacterienne) throws ReferentielException;

    DermatoseInfBacterienne findDermatoseInfBacterienneById(Long id);

    DermatoseInfBacterienne findDermatoseInfBacterienneByLibelle(String libelle);

    List<DermatoseInfBacterienne> findAllDermatoseInfBacteriennes();

    void deleteDermatoseInfBacterienne(Long id);

    /*************** DermatoseInfectieuse *************/
    void saveDermatoseInfectieuse(DermatoseInfectieuse dermatoseInfectieuse) throws ReferentielException;

    void updateDermatoseInfectieuse(Long id, DermatoseInfectieuse dermatoseInfectieuse) throws ReferentielException;

    DermatoseInfectieuse findDermatoseInfectieuseById(Long id);

    DermatoseInfectieuse findDermatoseInfectieuseByLibelle(String libelle);

    List<DermatoseInfectieuse> findAllDermatoseInfectieuses();

    void deleteDermatoseInfectieuse(Long id);

    /**********   Dermatose Inflammatoire   *********/
    Long saveDermatoseInflammatoire(DermatoseInflammatoire dermatoseInflammatoire) throws ReferentielException;

    Long updateDermatoseInflammatoire(Long id, DermatoseInflammatoire dermatoseInflammatoire) throws ReferentielException;

    DermatoseInflammatoire findDermatoseInflammatoireById(Long id);

    DermatoseInflammatoire findDermatoseInflammatoireByLibelle(String libelle);

    List<DermatoseInflammatoire> findAllDermatoseInflammatoires();

    void deleteDermatoseInflammatoire(Long id);

    /**************   Dermatose Virale  **********/
    Long saveDermatoseInfVirale(DermatoseInfVirale dermatoseInfVirale) throws ReferentielException;

    Long updateDermatoseInfVirale(Long id, DermatoseInfVirale dermatoseInfVirale) throws ReferentielException;

    DermatoseInfVirale findDermatoseInfViraleById(Long id);

    DermatoseInfVirale findDermatoseInfViraleByLibelle(String libelle);

    List<DermatoseInfVirale> findAllDermatoseInfVirales();

    void deleteDermatoseInfVirale(Long id);

    /************ Examen dermatologique   ***/
    Long saveElementExamenDermatologique(ElementExamenDermatologique elementExamenDermatologique) throws ReferentielException;

    Long updateElementExamenDermatologique(Long id, ElementExamenDermatologique elementExamenDermatologique) throws ReferentielException;

    ElementExamenDermatologique findElementExamenDermatologiqueById(Long id);

    ElementExamenDermatologique findElementExamenDermatologiqueByLibelle(String libelle);

    List<ElementExamenDermatologique> findAllElementExamenDermatologiques();

    void deleteElementExamenDermatologique(Long id);

    /***********   Hypothese         *****/
    Long saveElementHypothese(ElementHypothese elementHypothese) throws ReferentielException;

    Long updateElementHypothese(Long id, ElementHypothese elementHypothese) throws ReferentielException;

    ElementHypothese findElementHypotheseById(Long id);

    SousElementHypothese findSousElementHypotheseById(Long id);

    SousElementDermatoseInf findSousElementDermatoseInfById(Long id);

    ElementHypothese findElementHypotheseByLibelle(String libelle);

    List<ElementHypothese> findAllElementHypotheses();

    void deleteElementHypothese(Long id);

    /*******   Plainte       ***/
    Long saveElementPlainte(ElementPlainte elementPlainte) throws ReferentielException;

    Long updateElementPlainte(Long id, ElementPlainte elementPlainte) throws ReferentielException;

    ElementPlainte findElementPlainteById(Long id);

    ElementPlainte findElementPlainteByLibelle(String libelle);

    List<ElementPlainte> findAllElementPlaintes();

    void deleteElementPlainte(Long id);

    /*******   RechercheNotion      ******/
    Long saveElementRechercheNotion(ElementRechercheNotion elementRechercheNotion) throws ReferentielException;

    Long updateElementRechercheNotion(Long id, ElementRechercheNotion elementRechercheNotion) throws ReferentielException;

    ElementRechercheNotion findElementRechercheNotionById(Long id);

    ElementRechercheNotion findElementRechercheNotionByLibelle(String libelle);

    List<ElementRechercheNotion> findAllElementRechercheNotions();

    void deleteElementRechercheNotion(Long id);

    /**************  Terrain  ****/
    Long saveElementTerrain(ElementTerrain elementTerrain) throws ReferentielException;

    Long updateElementTerrain(Long id, ElementTerrain elementTerrain) throws ReferentielException;

    ElementTerrain findElementTerrainById(Long id);

    ElementTerrain findElementTerrainByLibelle(String libelle);

    List<ElementTerrain> findAllElementTerrains();

    void deleteElementTerrain(Long id);
}
