package com.iho.sn.admin.remote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListeUtilisateurDs {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private boolean actif;
}
