package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Certificate;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends BaseRepository<Certificate> {

    Page<Certificate> findAllByDoctor(Pageable pageable, Doctor doctor);


}
