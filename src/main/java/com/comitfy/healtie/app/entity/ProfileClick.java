package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "article_click_uuid"))
public class ProfileClick extends BaseEntity {
    private UUID userUUID;
    private UUID doctorUUID;
}
