package com.iho.sn.admin.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "action")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action extends AbstractAuditableEntity {

    private String code;
    private String libelle;
}
