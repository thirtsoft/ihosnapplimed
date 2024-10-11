package com.iho.sn.dossiermedical.consultation.repository.spec;

import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical_;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalSearchDs;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ConsSpecs implements Specification<ConsultationMedical> {

    private final ConsultationMedicalSearchDs searchDs;

    public ConsSpecs(ConsultationMedicalSearchDs searchDs) {
        this.searchDs = searchDs;
    }

    @Override
    public Predicate toPredicate(Root<ConsultationMedical> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!isBlank(searchDs.getCode())) {
            predicates.add(criteriaBuilder.equal(root.get(ConsultationMedical_.code), searchDs.getCode()));
        }
        if (!isBlank(searchDs.getNumero())) {
            predicates.add(criteriaBuilder.equal(root.get(ConsultationMedical_.numeroConsultation), searchDs.getNumero()));
        }
        if (searchDs.estRempli()) {
            predicates.add(criteriaBuilder
                    .between(root.get(ConsultationMedical_.dateConsultation), searchDs.getFrom(), searchDs.getTo()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}
