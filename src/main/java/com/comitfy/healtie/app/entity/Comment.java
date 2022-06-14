package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "comment_uuid"
        )
)
public class Comment extends BaseEntity {

    @Column
    private String content;
    @Column
    private String userName;

    @ManyToOne
    private Comment parent;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private Article article;

    @ManyToMany
    private Set<User> userLikes;

    public void removeLike(User user) {
        this.userLikes.remove(user);
    }


    public void addLike(User user) {
        this.userLikes.add(user);
    }


}
