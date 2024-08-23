package com.iho.sn.dossiermedical.rendezvous.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVousDeplaceDs {

    private List<RendezVousDetailsDs> rendezVousDetailDs;

    private Date dateDeplace;

    private String heure;
}
