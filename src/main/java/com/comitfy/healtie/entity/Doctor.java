package com.comitfy.healtie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Doctor extends BaseEntity {


    private String title;//unvanı
    private String diplomaNo;
    @OneToOne
    private User user;






//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_nationality",
//            joinColumns = @JoinColumn(name = "nationality_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id",
//                    referencedColumnName = "id"))
//    private List<Nationality> nationalities;

}
