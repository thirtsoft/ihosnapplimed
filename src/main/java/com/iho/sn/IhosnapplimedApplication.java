package com.iho.sn;

import com.iho.sn.admin.repository.ActionRepository;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.repository.UtilisateurRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.DiscussionRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.ExamenComplementaireRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.HospitalisationRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.SyntheseRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.TraitementMedicalItemRepository;
import com.iho.sn.dossiermedical.hospitalisation.repository.TraitementMedicalRepository;
import com.iho.sn.dossiermedical.patient.repository.PatientRepositry;
import com.iho.sn.referentiel.repository.MedicamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
@Transactional
public class IhosnapplimedApplication implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final ActionRepository actionRepository;
    private final ProfilRepository profilRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepositry patientRepositry;

    private final PatientRepositry patientRepository;
    private final ExamenComplementaireRepository examenComplementaireRepository;
    private final DiscussionRepository discussionRepository;
    private final SyntheseRepository syntheseRepository;
    private final MedicamentRepository medicamentRepository;
    private final TraitementMedicalItemRepository traitementMedicalItemRepository;
    private final TraitementMedicalRepository traitementMedicalRepository;
    private final HospitalisationRepository hospitalisationRepository;

    private static int numeroHospitalisation = 1;


    public static void main(String[] args) {
        SpringApplication.run(IhosnapplimedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        Action action1 = new Action("ADD_PAT", "Ajouter/Modifier un patient");
        Action action2 = new Action("ADD_AG", "Ajouter/Modifier un agent medicale");
        Action action3 = new Action("LST_PAT", "Lister les patients");
        Action action4 = new Action("LST_AG", "Lister les agents du service");
        Action action5 = new Action("ADD_RV", "Ajouter/Modifier un rendez-vous");
        Action action6 = new Action("ADD_CIR", "Générer un circuit d'un patient");
        Profil profileAdmin = new Profil("ADMIN", "Administrateur", Set.of(action1, action2, action3, action4, action5, action6), 1);
        Profil profileUser = new Profil("USER", "Utilisateur", Set.of(action1, action4, action6), 1);

        actionRepository.saveAll(of(action1, action2, action3, action4, action5, action6));
        profilRepository.saveAll(of(profileAdmin, profileUser));

        String motDePasse = passwordEncoder.encode("root");
        Utilisateur tairou = Utilisateur.builder()
                .email("saliouwourydiallokk@gmail.com")
                .prenom("Tairou")
                .nom("Diallo")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        TimeUnit.SECONDS.sleep(2);
        Utilisateur saliou = Utilisateur.builder()
                .email("saliouwourydiallo3kk@gmail.com")
                .prenom("Saliou Woury")
                .nom("Diallo")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        TimeUnit.SECONDS.sleep(2);
        Utilisateur tahirou = Utilisateur.builder()
                .email("thirdiallo@gmail.com")
                .prenom("Mamadou Tahirou")
                .nom("Diallo")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        utilisateurRepository.saveAll(of(tairou, saliou, tahirou));


        Patient tahirou = new Patient();
        tahirou.setPrenom("Tahirou");
        tahirou.setNom("Diallo");
        tahirou.setNumeroTelephone("779440310");
        tahirou.setAge(33);
        tahirou.setCivilite("M.");
        tahirou.setAddress("Hann-Mariste");
        tahirou.setDateAdmission(new Date());
        tahirou.setActif(true);
        Patient saliou = new Patient();
        saliou.setPrenom("saliou");
        saliou.setNom("Diallo");
        saliou.setNumeroTelephone("779330310");
        saliou.setAge(33);
        saliou.setCivilite("M.");
        saliou.setAddress("Lyon");
        saliou.setDateAdmission(new Date());
        saliou.setActif(true);
        Patient fama = new Patient();
        fama.setPrenom("fama");
        fama.setNom("Diop");
        fama.setNumeroTelephone("789330310");
        fama.setAge(23);
        fama.setCivilite("Mme");
        fama.setAddress("PA");
        fama.setDateAdmission(new Date());
        fama.setActif(true);
        patientRepositry.saveAll(of(tahirou, saliou, fama));*/

        /*
        //--------------------------------------------------------------------------------------------

        Patient patient = Patient.builder()
                .code("0001")
                .nom("Diallo")
                .prenom("Saliou")
                .numeroTelephone("77 000 00 00")
                .address("addresse")
                .dateAdmission(now().toDate())
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
                .dateAdmission(now().toDate())
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
        Medicament medicament = medicamentRepository.save(Medicament.builder().categoryMedicamentId(22L).code("MEDOC_01").libelle("libelle").actif(1).build());

        TraitementMedicalItem traitementMedicalItem = traitementMedicalItemRepository.save(TraitementMedicalItem.builder()
                .medicamendId(medicament.getCategoryMedicamentId())
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
                .numeroHospitalisation(0)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(EN_COURS)
//                .dateEnregistrement(DateTime.now())
                .build();
        Hospitalisation hospitalisation1 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(SORTIE)
                .build();
        Hospitalisation hospitalisation2 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(EN_COURS)
                .build();
        Hospitalisation hospitalisation3 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(EN_COURS)
                .build();
        Hospitalisation hospitalisation4 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(SORTIE)
                .build();
        Hospitalisation hospitalisation5 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(TRANSFERE)
                .build();
        Hospitalisation hospitalisation6 = Hospitalisation.builder()
                .code(patient.getCode())
                .numeroHospitalisation(numeroHospitalisation + 1)
                .examenComplementaire(savedExamenComplementaire)
                .traitementMedical(savedTraitementMedical)
                .discussion(discussion)
                .synthese(synthese)
                .statusHospitalisation(DECES)
                .build();

        hospitalisationRepository.save(hospitalisation);
//        hospitalisationRepository.saveAll(of(hospitalisation, hospitalisation1, hospitalisation2, hospitalisation3, hospitalisation4, hospitalisation5, hospitalisation6));

//        System.out.println("savedHospitalisation " + savedHospitalisation);

*/
    }
}
