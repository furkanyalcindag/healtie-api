package com.comitfy.healtie.entity.entityRelations;

import com.comitfy.healtie.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserAndPinnedArticle extends BaseEntity {

    private long userId;
    private long articleId;
}
