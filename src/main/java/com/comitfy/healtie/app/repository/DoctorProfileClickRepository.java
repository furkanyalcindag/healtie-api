package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.ArticleClick;
import com.comitfy.healtie.app.entity.DoctorProfileClick;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorProfileClickRepository extends BaseRepository<DoctorProfileClick> {

  /*  @Query("SELECT articleClick from ArticleClick  articleClick"+
    " inner join articleClick.articleUUID article WHERE articleClick.uuid=?1")
    Page<ArticleClick> getClickedArticleOfUser(Pageable pageable, UUID uuid); */

    /*

       @Query("SELECT article from Article article" +
            " inner join article.userLikes likes WHERE likes.uuid=?1")
    Page<Article> getLikedArticleOfUser(Pageable pageable, UUID uuid);*/

  // Page<ArticleClick> findAllByUser(Pageable pageable, UUID uuid);
}
