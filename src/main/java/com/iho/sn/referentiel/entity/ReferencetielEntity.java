package com.iho.sn.referentiel.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ReferencetielEntity extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
    private String code;

    private String libelle;

}
