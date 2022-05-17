package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.common.BaseRepository;
import com.comitfy.healtie.util.common.BaseWithMultiLanguageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ArticleRepository extends BaseWithMultiLanguageRepository<Article> {

    Page<Article> findAllByDoctorAndLanguageEnum(Pageable pageable, Doctor doctor, LanguageEnum languageEnum);

    //Page<Article> findAllByCategory(Pageable pageable, Category category);

    @Query("SELECT COUNT(likes) FROM Article article " +
            "inner join article.userLikes likes  WHERE article.uuid=?1")
    long getCountOfArticleLike(UUID articleUUID);

    @Query("SELECT COUNT(saves) FROM Article article " +
            "inner join article.userSaves saves  WHERE article.uuid=?1")
    long getCountOfArticleSave(UUID articleUUID);



}
