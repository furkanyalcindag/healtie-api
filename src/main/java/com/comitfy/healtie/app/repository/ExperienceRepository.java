package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.entity.Experience;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends BaseRepository<Experience> {
    Page<Experience> findAllByDoctor(Pageable pageable, Doctor doctor);
}
