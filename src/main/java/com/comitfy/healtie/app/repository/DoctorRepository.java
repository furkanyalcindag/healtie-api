package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends BaseRepository<Doctor> {


    Optional<Doctor> findByUser(User user);

    @Query("SELECT COUNT(likes) from Article article" +
            " inner join article.userLikes likes  inner join article.user user where user.uuid=?1")
    long getCountOfArticleLikes(UUID userUUID);


}
