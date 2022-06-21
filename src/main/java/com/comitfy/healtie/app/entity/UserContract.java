package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.dto.ContractDTO;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
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
