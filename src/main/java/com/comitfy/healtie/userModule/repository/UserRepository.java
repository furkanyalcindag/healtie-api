package com.comitfy.healtie.userModule.repository;


import com.comitfy.healtie.app.entity.Article;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.entity.Gender;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);


}
