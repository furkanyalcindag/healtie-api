package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Comment extends BaseEntity {

    private String content;

/*    @ManyToMany
    private Set<Comment> parent;*/

    @ManyToOne
    private Comment parent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private Article article;


}
