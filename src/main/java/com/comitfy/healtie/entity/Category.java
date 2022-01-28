package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Category {
    @Id
    private Long id;
    private String keyword;
    private long parentId;


}
