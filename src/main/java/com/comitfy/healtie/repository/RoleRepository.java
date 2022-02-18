package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByName(String name);

}
