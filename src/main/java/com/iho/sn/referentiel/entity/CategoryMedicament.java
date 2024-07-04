package com.iho.sn.referentiel.entity;

import com.iho.sn.config.AbstractAuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "category_medicament")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryMedicament extends AbstractAuditableEntity implements Serializable {
}
