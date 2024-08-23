package com.iho.sn.dossiermedical.hospitalisation.assembler;


import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.hospitalisation.entity.Discussion;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.DiscussionDs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DiscussionAssembler {

    private final UtilisateurService utilisateurService;

    public List<DiscussionDs> assembleEntitiesFrom(List<Discussion> discussions) {
        return discussions.stream().map(this::assembleEntityToDs).toList();
    }

    public List<Discussion> assembleEntitiesFromDs(List<DiscussionDs> discussions) {
        return discussions.stream().map(this::assembleDiscussionFromDs).toList();
    }

    public DiscussionDs assembleEntityToDs(Discussion discussion) {
        DiscussionDs discussionDs = new DiscussionDs();
        if (discussion.getId() != null)
            discussionDs.setId(discussion.getId());
        discussionDs.setResume(discussion.getResume());
        if (discussion.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(discussion.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + " " + utilisateur.getNom();
            discussionDs.setNomCompletAgent(nomAgent);
        }
        discussionDs.setCreatedDate(discussion.getCreationDate());
        return discussionDs;
    }


    public Discussion assembleDiscussionFromDs(DiscussionDs discussionDs) {
        Discussion discussion = new Discussion();
        if (discussionDs.getId() != null)
            discussion.setId(discussionDs.getId());
        discussion.setResume(discussionDs.getResume());
        return discussion;
    }

    public Discussion assembleUpdateDiscussionFromDs(Discussion discussion, DiscussionDs discussionDs) {
        discussion.setResume(discussionDs.getResume());
        return discussion;
    }
}