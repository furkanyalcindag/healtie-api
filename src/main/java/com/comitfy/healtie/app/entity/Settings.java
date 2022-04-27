package com.comitfy.healtie.app.entity;

import com.comitfy.healtie.util.dbUtil.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Settings extends BaseEntity {

    @Column(unique = true)
    private String key;

    @Column
    private String value;

}
