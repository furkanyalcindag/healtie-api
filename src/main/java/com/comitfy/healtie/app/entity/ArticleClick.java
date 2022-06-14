package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "article_click_uuid"))
public class ArticleClick extends BaseEntity {

    @Column
    @Type(type = "uuid-char")
    private UUID articleUuid;


    @Column
    @Type(type = "uuid-char")
    private UUID userUuid;


}
