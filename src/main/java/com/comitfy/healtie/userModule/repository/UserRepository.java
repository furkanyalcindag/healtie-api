package com.comitfy.healtie.userModule.repository;


import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);

    @Query("SELECT COUNT(article.uuid) from Article article" +
            " inner join article.userLikes likes  where likes.uuid=?1")
    long getLikeCountByUser(UUID userUUID);

    @Query("SELECT COUNT(article.uuid) from Article article" +
            " inner join article.userSaves saves  where saves.uuid=?1")
    long getSaveCountByUser(UUID userUUID);


}
