package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
