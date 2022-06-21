package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@AttributeOverride(name = "uuid", column = @Column(name = "contract_uuid"))
public class Contract extends BaseEntity {

    @Column
    private String key;

    @Column
    private String title;

    @Column(columnDefinition = "Text", length = 100000)
    private String content;

    @Column
    private boolean isRequired;

    @Column
    private boolean activated;

    @Column
    private int orderOfContract;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;


 /*   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private User user;*/


}

