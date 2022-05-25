package com.comitfy.healtie.app.specification;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseSpecification;
import com.comitfy.healtie.util.common.SearchCriteria;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorSpecification extends BaseSpecification<Doctor> {

    @Override
    public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : super.getCriterias()) {
            Predicate predicate = null;
            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.greaterThanOrEqualTo(

                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equals("=")) {
                if (criteria.getKey().equals("doctorUUID")) {
                    predicate = builder.equal(
                            root.<String>get("doctor_uuid"), criteria.getValue());

                } else {
                    predicate = builder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue());

                }
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.lessThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (criteria.getKey().equals("lastName")) {

                    Join<Doctor, User> join = root.join("user");
                    predicate = builder.like(builder.lower(join.get("lastName").as(String.class)), "%" + criteria.getValue().toString() + "%");

                } else if (criteria.getKey().equals("firstName")) {

                    Join<Doctor, User> join = root.join("user");
                    predicate = builder.like(builder.lower(join.get("firstName").as(String.class)), "%" + criteria.getValue().toString() + "%");

                } else if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicate = builder.like(
                            builder.lower(root.<String>get(criteria.getKey())), "%" + criteria.getValue() + "%");

                } else {
                    predicate = builder.equal(root.get(criteria.getKey()), criteria.getValue());
                }
            } else {
                continue;
            }

            predicates.add(predicate);

        }

        return builder.and(predicates.toArray(new Predicate[predicates.size()]));

    }
}
