package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    private Long id;
    private String keyword;


    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent_id", nullable = true)
    private Category category;

    @OneToMany(mappedBy="category")
    private Set<Category> subCategory = new HashSet<Category>();


}
