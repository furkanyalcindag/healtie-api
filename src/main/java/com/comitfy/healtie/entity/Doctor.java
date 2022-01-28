package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Doctor extends BaseEntity {
    @Column(nullable = false)
    private String name;
    private String surname;
    //private String userType;
    private String title;//unvanı
    private String phone;
    private String birthDate;
    private String email;
    private String address;
    private String genderId;
    private String nationalityId;
    private String countryId;
    @Column(length = 255)
    private String password;
    private boolean isEnable;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_nationality",
//            joinColumns = @JoinColumn(name = "nationality_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id",
//                    referencedColumnName = "id"))
//    private List<Nationality> nationalities;

}
