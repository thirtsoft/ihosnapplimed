package com.iho.sn.dossiermedical.hospitalisation.repository;

import com.iho.sn.dossiermedical.hospitalisation.entity.Discussion;
import com.iho.sn.dossiermedical.hospitalisation.entity.ExamenComplementaire;
import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import com.iho.sn.dossiermedical.hospitalisation.entity.Synthese;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedicalItem;
import com.iho.sn.dossiermedical.patient.entity.Diagnostic;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.repository.PatientRepositry;
import com.iho.sn.referentiel.entity.Medicament;
import com.iho.sn.referentiel.repository.MedicamentRepository;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
@Disabled
class HospitalisationRepositoryTest {


    @Autowired
    private PatientRepositry patientRepository;
    @Autowired
    private ExamenComplementaireRepository examenComplementaireRepository;
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private SyntheseRepository syntheseRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Autowired
    private TraitementMedicalItemRepository traitementMedicalItemRepository;
    @Autowired
    private TraitementMedicalRepository traitementMedicalRepository;
    @Autowired
    private HospitalisationRepository hospitalisationRepository;

    @Test()
    @Disabled
    void save_hospi() {

        Patient patient = Patient.builder()
                .code("0001")
                .nom("Diallo")
                .prenom("Saliou")
                .numeroTelephone("77 000 00 00")
                .address("addresse")
                .dateAdmission(LocalDate.now().toDate())
                .age(25)
                .race("race")
                .ethnie("ethnie")
                .origine("origine").nationalite("nationalite").originePere("originePere")
                .origineMere("origineMere").prototype("prototype").consanguinite("consanguinite")
                .niveauSocialEconomique("niveauSocialEconomique").regimeAlimentaire("regimeAlimentaire")
                .diagnostic(Diagnostic.builder()
                        .diagnostic_principal("diagnostic_principal")
                        .diagnostic_associe("diagnostic_associe")
                        .build())
                .actif(1)
                .build();
        Patient patient1 = Patient.builder()
                .code("0002")
                .nom("Diallo")
                .prenom("Tahiou")
                .numeroTelephone("77 000 00 00")
                .address("addresse")
                .dateAdmission(LocalDate.now().toDate())
                .age(25)
                .race("race...")
                .ethnie("ethnie...")
                .origine("origine...").nationalite("nationalite...")
                .originePere("originePere...")
                .origineMere("origineMere...")
                .prototype("prototype...")
                .consanguinite("consanguinite...")
                .niveauSocialEconomique("niveauSocialEconomique...")
                .regimeAlimentaire("regimeAlimentaire...")
                .diagnostic(Diagnostic.builder()
                        .diagnostic_principal("diagnostic_principal...")
                        .diagnostic_associe("diagnostic_associe...")
                        .build())
                .actif(1)
                .build();
        patientRepository.saveAll(List.of(patient, patient1));

        ExamenComplementaire examenComplementair = ExamenComplementaire.builder()
                .biologie("biologie")
                .immunologie("immunologie")
                .imagerie("imagerie")
                .anatomopathologie("anatomopathologie")
                .build();
        ExamenComplementaire savedExamenComplementaire = examenComplementaireRepository.save(examenComplementair);
        Discussion discussion = discussionRepository.save(Discussion.builder().resume("resume resume").build());
        Synthese synthese = syntheseRepository.save(Synthese.builder().observation("observation observation").build());
        Medicament medicament = medicamentRepository.save(Medicament.builder().code("MEDOC_01").libelle("libelle").actif(1).build());

        TraitementMedicalItem traitementMedicalItem = traitementMedicalItemRepository.save(TraitementMedicalItem.builder()
                .medicamendId(medicament.getId())
                .psologie("psologie")
                .administrePar("oral")
                .nbrePrise("2")
                .build());


        TraitementMedical traitementMedical = TraitementMedical.builder()
                .traitementMedicalItems(Collections.singleton(traitementMedicalItem))
                .build();

        TraitementMedical savedTraitementMedical = traitementMedicalRepository.save(traitementMedical);

        Hospitalisation hospitalisation = Hospitalisation.builder()
                .code(patient.getCode())
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .build();

        Hospitalisation savedHospitalisation = hospitalisationRepository.save(hospitalisation);

        System.out.println("savedHospitalisation " + savedHospitalisation);
    }

}