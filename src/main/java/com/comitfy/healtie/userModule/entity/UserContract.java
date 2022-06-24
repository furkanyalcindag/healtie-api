package com.comitfy.healtie.userModule.entity;

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
                name = "user_contract_uuid"
        )
)
public class UserContract extends BaseEntity {
    @Column
    @Type(type = "uuid-char")
    private UUID userUuid;

    @Column
    @Type(type = "uuid-char")
    private UUID contractUuid;

    @Column
    private boolean isSigned;
}
