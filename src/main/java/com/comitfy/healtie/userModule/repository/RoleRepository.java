package com.comitfy.healtie.userModule.repository;

import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends BaseRepository<Role> {

    Optional<Role> findByName(String name);

    //List<Role> findAllByUsers_Email(String email);

    List<Role> findAllByNameContains(String name, Pageable pageable);

}
