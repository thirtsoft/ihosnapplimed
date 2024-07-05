package com.iho.sn.admin.remote.model;

import lombok.Data;

@Data
public class ChangerMotDePasseRequest {
    private String email;
    private String ancienMotDePasse;
    private String nouveauMotDePasse;
}