package com.comitfy.healtie.repository;

import com.comitfy.healtie.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
