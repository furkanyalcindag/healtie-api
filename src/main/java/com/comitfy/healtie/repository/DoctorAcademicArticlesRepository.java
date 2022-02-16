package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.AcademicArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorAcademicArticlesRepository extends JpaRepository<AcademicArticle, Long> {

}
