package com.iho.sn.dossiermedical.hospitalisation.service.impl;

import com.iho.sn.dossiermedical.hospitalisation.entity.Discussion;
import com.iho.sn.dossiermedical.hospitalisation.repository.DiscussionRepository;
import com.iho.sn.dossiermedical.hospitalisation.service.DiscussionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiscussionServiceImpl implements DiscussionService {

    private final DiscussionRepository discussionRepository;

    @Override
    public Discussion saveDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public Discussion updateDiscussion(Long id, Discussion discussion) {
        if (!discussionRepository.existsById(id)) {
            log.info("Discussion that this id " + id + "not found");
        }
        discussion.setId(id);
        return discussionRepository.save(discussion);
    }

    @Override
    public Discussion findById(Long id) {
        return discussionRepository.findDiscussionById(id);
    }

    @Override
    public List<Discussion> findAllDiscussions() {
        return discussionRepository.findAllDiscussions();
    }

    @Override
    public void deleteDiscussion(Long id) {
        Discussion discussion = discussionRepository.findDiscussionById(id);
        discussionRepository.save(discussion);
    }
}