package com.iho.sn.admin.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder(toBuilder = true)
public abstract class AbstractAuditableEntity extends AbstractEntity {

    @CreatedDate
    @Column(nullable = false,
            updatable = false
    )
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Basic(fetch = FetchType.LAZY)
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(nullable = false,
            updatable = false
    )
    @Basic(fetch = FetchType.LAZY)
    private @Size(max = 50) String createdByUser;

    @LastModifiedBy
    @Basic(fetch = FetchType.LAZY)
    private @Size(max = 50) String lastModifiedBy;
}
