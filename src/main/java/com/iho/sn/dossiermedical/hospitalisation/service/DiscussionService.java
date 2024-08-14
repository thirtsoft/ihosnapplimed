package com.iho.sn.dossiermedical.hospitalisation.service;


import com.iho.sn.dossiermedical.hospitalisation.entity.Discussion;

import java.util.List;

public interface DiscussionService {

    Discussion saveDiscussion(Discussion discussion);

    Discussion updateDiscussion(Long id, Discussion discussion);

    Discussion findById(Long id);

    List<Discussion> findAllDiscussions();

    void deleteDiscussion(Long id);
}