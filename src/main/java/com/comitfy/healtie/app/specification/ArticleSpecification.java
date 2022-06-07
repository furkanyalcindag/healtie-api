package com.comitfy.healtie.app.specification;

import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.entity.Tag;
import com.comitfy.healtie.util.common.BaseSpecification;
import com.comitfy.healtie.util.common.SearchCriteria;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ArticleSpecification extends BaseSpecification<Article> {

    @Override
    public Predicate toPredicate
            (Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : super.getCriterias()) {
            Predicate predicate = null;
            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.greaterThanOrEqualTo(

                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equals("=")) {
                if (criteria.getKey().equals("articleUUID")) {
                    predicate = builder.equal(
                            root.<String>get("article_uuid"), criteria.getValue());

                } else if (criteria.getKey().equals("categoryUUID")) {

                    Join<Article, Category> join = root.join("categoryList");
                    predicate = builder.equal(join.get("uuid").as(UUID.class), UUID.fromString(criteria.getValue().toString()));

                }  else {
                    predicate = builder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue());

                }
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.lessThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
                 if (criteria.getKey().equals("tag")) {
                    Join<Article, Tag> join = root.join("tags");
                    predicate = builder.like( builder.lower(join.get("name").as(String.class)), "%" + criteria.getValue().toString().toLowerCase()+ "%");
                }
                else if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicate = builder.like(
                            builder.lower(root.<String>get(criteria.getKey())), "%" + criteria.getValue() + "%");

                }
                else {
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
