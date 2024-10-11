package com.iho.sn;

import com.iho.sn.admin.repository.ActionRepository;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.repository.UtilisateurRepository;
import com.iho.sn.dossiermedical.patient.repository.PatientRepositry;
import com.iho.sn.referentiel.entity.ElementHypothese;
import com.iho.sn.referentiel.entity.SousElementDermatoseInf;
import com.iho.sn.referentiel.entity.SousElementHypothese;
import com.iho.sn.referentiel.repository.ElementExamenDermatologiqueRepository;
import com.iho.sn.referentiel.repository.ElementHypotheseRepository;
import com.iho.sn.referentiel.repository.ElementPlainteRepository;
import com.iho.sn.referentiel.repository.ElementTerrainRepository;
import com.iho.sn.referentiel.repository.SousElementDermatoseInfRepository;
import com.iho.sn.referentiel.repository.SousElementHypotheseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static java.util.List.of;


@SpringBootApplication
@RequiredArgsConstructor
@Transactional
public class IhosnapplimedApplication implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final ActionRepository actionRepository;
    private final ProfilRepository profilRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepositry patientRepositry;

    private final ElementTerrainRepository elementTerrainRepository;
    private final ElementPlainteRepository elementPlainteRepository;
    private final ElementExamenDermatologiqueRepository elementExamenDermatologiqueRepository;
    private final ElementHypotheseRepository elementHypotheseRepository;
    private final SousElementHypotheseRepository sousElementHypotheseRepository;
    private final SousElementDermatoseInfRepository sousElementDermatoseInfRepository;
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
                .prenom("Saliou")
                .nom("Diallo")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        TimeUnit.SECONDS.sleep(2);
        Utilisateur saliou = Utilisateur.builder()
                .email("hilairesarr@gmail.com")
                .prenom("Hilaire")
                .nom("Sarr")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        TimeUnit.SECONDS.sleep(2);
        Utilisateur tahirou = Utilisateur.builder()
                .email("thirdiallo@gmail.com")
                .prenom("Tairou")
                .nom("Diallo")
                .matricule(genererMatricule())
                .motdepasse(motDePasse)
                .profil(profileAdmin)
                .actif(true)
                .build();
        utilisateurRepository.saveAll(of(tairou, saliou, tahirou));
*/

        /************ SousElementDermatoseInf   *******************/
        /*
        SousElementDermatoseInf inf1 = new SousElementDermatoseInf();
        inf1.setLibelle("maladie de Hansen");
        inf1.setActif(true);

        SousElementDermatoseInf inf2 = new SousElementDermatoseInf();
        inf2.setLibelle("tuberculose cutane");
        inf2.setActif(true);

        SousElementDermatoseInf inf3 = new SousElementDermatoseInf();
        inf3.setLibelle("gale");
        inf3.setActif(true);

        SousElementDermatoseInf inf4 = new SousElementDermatoseInf();
        inf4.setLibelle("mycosique");
        inf4.setActif(true);

        SousElementDermatoseInf inf5 = new SousElementDermatoseInf();
        inf5.setLibelle("varicella");
        inf5.setActif(true);

        SousElementDermatoseInf inf6 = new SousElementDermatoseInf();
        inf6.setLibelle("rogeole");
        inf6.setActif(true);

        SousElementDermatoseInf inf7 = new SousElementDermatoseInf();
        inf7.setLibelle("herpes");
        inf7.setActif(true);

        SousElementDermatoseInf inf8 = new SousElementDermatoseInf();
        inf8.setLibelle("ulcere de jambe");
        inf8.setActif(true);

        sousElementDermatoseInfRepository.saveAll(of(inf1, inf2, inf3, inf4, inf5, inf6, inf7, inf8));


         */
        /***************  SousElementHypothese ********************/
        /*
        SousElementHypothese s1 = new SousElementHypothese();
        s1.setLibelle("Eczema");
        s1.setActif(true);
        s1.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        SousElementHypothese s2 = new SousElementHypothese();
        s2.setLibelle("Dermatite atopique");
        s2.setActif(true);
        s2.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        SousElementHypothese s3 = new SousElementHypothese();
        s3.setLibelle("Acné");
        s3.setActif(true);
        s3.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        SousElementHypothese s4 = new SousElementHypothese();
        s4.setLibelle("Lupus");
        s4.setActif(true);
        s4.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        SousElementHypothese s5 = new SousElementHypothese();
        s5.setLibelle("Dermatomyosite");
        s5.setActif(true);
        s5.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        SousElementHypothese s6 = new SousElementHypothese();
        s6.setLibelle("Bactériennes");
        s6.setActif(true);
        s6.setSousElementDermatoseInfs(Set.of(inf1.getId(), inf2.getId(), inf3.getId()));

        SousElementHypothese s7 = new SousElementHypothese();
        s7.setLibelle("Virale");
        s7.setActif(true);
        s7.setSousElementDermatoseInfs(Set.of(inf1.getId(), inf6.getId(), inf7.getId(), inf8.getId()));

        SousElementHypothese s8 = new SousElementHypothese();
        s8.setLibelle("Toxidermie");
        s8.setActif(true);
        s8.setSousElementDermatoseInfs(Set.of(inf1.getId()));

        sousElementHypotheseRepository.saveAll(of(s1, s2, s3, s4, s5, s6, s7, s8));

         */

        /***       Element Hypothèse        *******/
        /*
        ElementHypothese e1 = new ElementHypothese();
        e1.setLibelle("Dermatoses inflammatoire");
        e1.setActif(true);
        e1.setSousElementHypothese(Set.of(s1, s2, s3));

        ElementHypothese e2 = new ElementHypothese();
        e2.setLibelle("Dermatose autoimmune");
        e2.setActif(true);
        e2.setSousElementHypothese(Set.of(s4, s5));

        ElementHypothese e3 = new ElementHypothese();
        e3.setLibelle("Dermatose bulleuse");
        e3.setActif(true);
        e3.setSousElementHypothese(Set.of(s8));

        ElementHypothese e4 = new ElementHypothese();
        e4.setLibelle("Dermatoses infectieuses");
        e4.setActif(true);
        e4.setSousElementHypothese(Set.of(s6, s7));
        elementHypotheseRepository.saveAll(of(e1, e2, e3, e4));

         */


    }
}
