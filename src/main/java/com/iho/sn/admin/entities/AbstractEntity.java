package com.iho.sn.admin.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "GenerationDeSequence")
    @SequenceGenerator(name = "GenerationDeSequence", sequenceName = "GEN_SEG_GEN", allocationSize = 1)
    private Long id;
    @Version
    private Long version;
}
