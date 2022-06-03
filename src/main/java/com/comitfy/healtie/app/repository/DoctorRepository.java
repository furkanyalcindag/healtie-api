package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends BaseRepository<Doctor> {

/*
    @Query("SELECT COUNT(articles) FROM Doctor doctor" +
            " inner join doctor.articleList articles where doctor.uuid=?1")
    long getCountOfArticles(UUID doctorUUID);
*/

}
