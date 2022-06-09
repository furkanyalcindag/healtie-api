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

    select article.id,count(article.id) from article
inner join article_user_likes on article_user_likes.article_id = article.id group by article.id
having article.doctor_id=1


    */

/*    @Query("SELECT COUNT(article.userLikes) from Article article" +
            " inner join article.userLikes on article.userLikes=article.id group by article.id having  article.doctor.id=?1")
    long getCountOfArticleLikes(UUID doctorUUID);*/


}
