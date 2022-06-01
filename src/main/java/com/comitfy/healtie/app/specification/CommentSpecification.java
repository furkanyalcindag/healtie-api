package com.comitfy.healtie.app.specification;

import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Comment;
import com.comitfy.healtie.util.common.BaseSpecification;
import com.comitfy.healtie.util.common.SearchCriteria;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class CommentSpecification extends BaseSpecification<Comment> {

    @Override
    public Predicate toPredicate(Root<Comment> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : super.getCriterias()) {
            Predicate predicate = null;
            if (criteria.getOperation().equals("=")) {
                if (criteria.getKey().equals("articleUUID")) {
                    Join<Comment, Article> join = root.join(("article"));
                    predicate = builder.equal(join.get("uuid").as(UUID.class), UUID.fromString(criteria.getValue().toString()));

                } else {
                    predicate = builder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue());
                }
            } else {
                continue;
            }
            predicates.add(predicate);

        }
        return builder.and(predicates.toArray(new Predicate[predicates.size()]));

    }


    /*if (criteria.getKey().equals("commentUUID")) {
                    predicate = builder.equal(root.<String>get("comment_uuid"), criteria.getValue());
                } else */
}
