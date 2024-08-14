package com.iho.sn.dossiermedical.hospitalisation.remote.controller;

import com.iho.sn.dossiermedical.hospitalisation.assembler.DiscussionAssembler;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.DiscussionApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.DiscussionDs;
import com.iho.sn.dossiermedical.hospitalisation.service.DiscussionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiscussionController implements DiscussionApi {

    private final DiscussionService discussionService;
    private final DiscussionAssembler discussionAssembler;

    @Override
    public ResponseEntity<DiscussionDs> creerDiscussion(DiscussionDs discussionDs) {
        return new ResponseEntity<>(discussionAssembler.assembleEntityToDs(
                discussionService.saveDiscussion(discussionAssembler.assembleDiscussionFromDs(discussionDs))
        ), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DiscussionDs> updateDiscussion(Long id, DiscussionDs discussionDs) {
        return new ResponseEntity<>(discussionAssembler.assembleEntityToDs(
                discussionService.updateDiscussion(id, discussionAssembler.assembleDiscussionFromDs(discussionDs))
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DiscussionDs> findById(Long id) {
        return new ResponseEntity<>(discussionAssembler.assembleEntityToDs(discussionService.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DiscussionDs>> findAllDiscussions() {
        return new ResponseEntity<>(discussionAssembler.assembleEntitiesFrom(
                discussionService.findAllDiscussions()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteDiscussion(Long id) {
        discussionService.deleteDiscussion(id);
    }
}