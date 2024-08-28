package com.iho.sn.admin.remote.controller.api;

import com.iho.sn.admin.remote.model.ActivationRequest;
import com.iho.sn.admin.remote.model.ChangerMotDePasseRequest;
import com.iho.sn.admin.remote.model.ListeUtilisateurDs;
import com.iho.sn.admin.remote.model.ResponseMassageDs;
import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.admin.remote.model.UtilisateurProfilDs;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/utilisateur")
public interface UtilisateurApi {

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMassageDs creerUtilisateur(@RequestBody @Valid UtilisateurDs utilisateurDs, HttpServletRequest request);

    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDs> updateUtilisateur(@RequestBody UtilisateurDs utilisateurDs);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurDs> findUtilisateurById(@PathVariable Long id);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ListeUtilisateurDs>> findAllUtilisateurs();

    @DeleteMapping(value = "/delete/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteUtilisateur(@PathVariable String email);

    @GetMapping(value = "/monprofil/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UtilisateurProfilDs> findUtilisateurProfil(@PathVariable Long id);

    @PostMapping(value = "/password-reset-request", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> resetPasswordRequest(@RequestBody ChangerMotDePasseRequest changerMotDePasseRequest, HttpServletRequest request);

    @PostMapping(value = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> changePassword(@RequestBody ChangerMotDePasseRequest requestUtil);

    @GetMapping(value = "/medecins", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UtilisateurDs>> findAllMedecins();

    @GetMapping(value = "/activated/{matricule}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> activatedAccount(@PathVariable String matricule);

    @GetMapping(value = "/deactivated/{matricule}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deactivatedAccount(@PathVariable String matricule);

    @GetMapping(value = "/activation")
    String activation(@RequestParam("code") String code);

    @PostMapping(value = "/createPassword", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> activationUser(@RequestBody @Valid ActivationRequest request);
}
