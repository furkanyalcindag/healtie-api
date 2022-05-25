package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseRepository;
import com.comitfy.healtie.util.common.BaseWithMultiLanguageRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DoctorRepository extends BaseWithMultiLanguageRepository<Doctor> {

}
