package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends BaseRepository<Doctor> {

/*
    @Query("SELECT COUNT(articles) FROM Doctor doctor" +
            " inner join doctor.articleList articles where doctor.uuid=?1")
    long getCountOfArticles(UUID doctorUUID);
*/


/*    @Query("select article.id,count(article.id) from Article article" +
            " inner join article.userLikes on article.userLikes=article.id group by article.id" +
            " having article.doctor.id=?1")
    long getCountOfArticleLikes(UUID doctorUUID);*/

    @Query("select article.id,count(article.id) from Article article" +
            " inner join article.userLikes where article.doctor.id=?1 group by article.id ")
    long getCountOfArticleLikes(UUID doctorUUID);


}
