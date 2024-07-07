package com.iho.sn;

import com.iho.sn.admin.entities.Action;
import com.iho.sn.admin.entities.Profil;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.repository.ActionRepository;
import com.iho.sn.admin.repository.ProfilRepository;
import com.iho.sn.admin.repository.UtilisateurRepository;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.repository.PatientRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.iho.sn.utils.UtilString.genererMatricule;
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
        patientRepositry.saveAll(of(tahirou, saliou, fama));

         */

    }
}
