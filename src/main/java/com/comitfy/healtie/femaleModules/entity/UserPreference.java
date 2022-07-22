package com.comitfy.healtie.femaleModules.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "user_preference_uuid"
        )
)
public class UserPreference extends BaseEntity {

    @Column
    @Type(type = "uuid-char")
    private UUID userUUID;

    @Column
    @Type(type = "uuid-char")
    private UUID preferenceUUID;


}
