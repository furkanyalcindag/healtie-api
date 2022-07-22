package com.comitfy.healtie.userModule.entity;

import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.entity.Tag;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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
    private Boolean required;

    @Column
    private Boolean activated;

    @Column
    private Integer orderOfContract;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;

    @ManyToMany
    private Set<Role> roleList;

 /*   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private User user;*/


}
//for döngüsünde contractuuid dön her döngüde kaydet validete yaptıgın yerde yap


