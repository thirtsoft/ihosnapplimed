package com.iho.sn.admin.service;

import com.iho.sn.admin.entities.Utilisateur;

public interface EnvoieMailService {

    void sendMailCreationUser(Utilisateur utilisateur) throws Exception;

    void sendMailForgotPass(Utilisateur utilisateur, String motDePasse) throws Exception;

    void sendMailUpdatePass(Utilisateur user) throws Exception;

}
