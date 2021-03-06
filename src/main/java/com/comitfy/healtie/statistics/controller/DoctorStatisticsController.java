package com.comitfy.healtie.statistics.controller;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.DoctorMapper;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.DoctorService;
import com.comitfy.healtie.app.specification.DoctorSpecification;
import com.comitfy.healtie.statistics.dto.DoctorStatisticsDTO;
import com.comitfy.healtie.statistics.service.DoctorStatisticsService;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor-statistics")
public class DoctorStatisticsController extends BaseCrudController<DoctorDTO, DoctorRequestDTO, Doctor, DoctorRepository, DoctorMapper, DoctorSpecification, DoctorService> {

    @Autowired
    DoctorStatisticsService doctorStatisticsService;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    HelperService helperService;

    @Autowired
    DoctorService doctorService;


    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @GetMapping("/total-likes/dashboard/doctor")
    public long getTotalLikesByDoctor(@RequestBody DoctorStatisticsDTO doctorStatisticsDTO) {
        User user = helperService.getUserFromSession();
        long dto = doctorStatisticsService.getCountOfLikesByDate(user.getUuid(), doctorStatisticsDTO);
        return dto;
    }
}
