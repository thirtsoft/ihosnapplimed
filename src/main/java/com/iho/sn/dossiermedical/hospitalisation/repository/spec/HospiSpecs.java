package com.iho.sn.dossiermedical.hospitalisation.repository.spec;

import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation_;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationSearchDs;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static com.iho.sn.enumeration.StatusHospitalisation.forHospitalisation;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class HospiSpecs implements Specification<Hospitalisation> {

    private final HospitalisationSearchDs searchDs;

    public HospiSpecs(HospitalisationSearchDs searchDs) {
        this.searchDs = searchDs;
    }

    @Override
    public Predicate toPredicate(Root<Hospitalisation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!isBlank(searchDs.getStatusHospitalisation())) {
            predicates.add(criteriaBuilder.equal(root.get(Hospitalisation_.statusHospitalisation), forHospitalisation(searchDs.getStatusHospitalisation())));
        }
        if (!isBlank(searchDs.getCode())) {
            predicates.add(criteriaBuilder.equal(root.get(Hospitalisation_.code), searchDs.getCode()));
        }
        if (searchDs.estRempli()) {
            predicates.add(criteriaBuilder
                    .between(root.get(Hospitalisation_.dateEnregistrement), searchDs.getFrom(), searchDs.getTo()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
