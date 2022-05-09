package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicInfoRepository extends BaseRepository<AcademicInfo> {
    //List<AcademicInfo> findAllAcademicInfoByDoctorId(@Param("id")Long id);
}
