package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Article extends BaseEntity {

    @Column
    private String name;

    @Column
    private String title;


    @ElementCollection
    private List<String> tag;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageEnum languageEnum;

  /*  @ManyToMany
    private Set<Category> categoryList;*/
/*
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AcademicInfo> academicInfoList;
*/
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private Doctor doctor;

    @ManyToMany
    private Set<User> userLikes;


    @ManyToMany
    private Set<User> userSaves;


    public void removeLike(User user) {
        this.userLikes.remove(user);
    }


    public void addLike(User user) {
        this.userLikes.add(user);
    }



    public void removeSave(User user){
        this.userSaves.remove(user);
    }
    public void addSave(User user){
        this.userSaves.add(user);
    }

}
