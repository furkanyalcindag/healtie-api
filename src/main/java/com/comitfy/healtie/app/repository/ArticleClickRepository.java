package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.ArticleClick;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleClickRepository extends BaseRepository<ArticleClick> {

  /*  @Query("SELECT articleClick from ArticleClick  articleClick"+
    " inner join articleClick.articleUUID article WHERE articleClick.uuid=?1")
    Page<ArticleClick> getClickedArticleOfUser(Pageable pageable, UUID uuid); */

    /*

       @Query("SELECT article from Article article" +
            " inner join article.userLikes likes WHERE likes.uuid=?1")
    Page<Article> getLikedArticleOfUser(Pageable pageable, UUID uuid);*/

  // Page<ArticleClick> findAllByUser(Pageable pageable, UUID uuid);
}
