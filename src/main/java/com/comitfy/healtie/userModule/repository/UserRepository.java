package com.comitfy.healtie.userModule.repository;


import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);

}
