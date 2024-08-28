package com.iho.sn.admin.event;

import com.iho.sn.admin.entities.ProfileProperties;
import com.iho.sn.admin.entities.Utilisateur;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private final Utilisateur utilisateur;
    private final String url;
    private String defaultPassword;

    @Autowired
    private ProfileProperties profileProperties;

    public RegistrationCompleteEvent(Utilisateur utilisateur, String url) {
        super(utilisateur);
        this.utilisateur = utilisateur;
        this.url = url;
    }
}
