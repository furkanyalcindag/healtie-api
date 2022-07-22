package com.comitfy.healtie.femaleModules.repository;

import com.comitfy.healtie.femaleModules.entity.FertilityLevel;
import com.comitfy.healtie.femaleModules.entity.OvulationCycle;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface OvulationCycleRepository extends BaseRepository<OvulationCycle> {


    boolean existsByUserAndActivated(User user, boolean isActive);
    OvulationCycle findByUser( User user);
    OvulationCycle findByActivatedAndUser(boolean isActive, User user);


    /*    Page<Contract> findAllByActivatedAndLanguageEnum(Pageable pageable, boolean isActive, LanguageEnum languageEnum);

    Page<Contract> findAllByRoleListInAndActivated(Pageable pageable, Set<Role> role, boolean isActive);*/
}
