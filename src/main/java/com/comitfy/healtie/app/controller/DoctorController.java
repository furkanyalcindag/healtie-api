package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.ArticleClickRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorProfileClickRequestDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.DoctorMapper;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.DoctorProfileClickService;
import com.comitfy.healtie.app.service.DoctorService;
import com.comitfy.healtie.app.specification.DoctorSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseCrudController<DoctorDTO, DoctorRequestDTO, Doctor, DoctorRepository, DoctorMapper, DoctorSpecification, DoctorService> {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorService doctorService;

    @Autowired
    HelperService helperService;

    @Autowired
    DoctorProfileClickService doctorProfileClickService;


    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getById(@RequestHeader(value = "accept-language", required = true) String acceptLanguage, @PathVariable UUID id) {
        DoctorDTO optionalT = getService().findByUUID(id);
        if (optionalT == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            User user = helperService.getUserFromSession();
            DoctorProfileClickRequestDTO doctorProfileClickRequestDTO = new DoctorProfileClickRequestDTO();
            doctorProfileClickRequestDTO.setDoctorUUID(optionalT.getUuid());
            doctorProfileClickRequestDTO.setUserUUID(user != null ? user.getUuid() : null);
            doctorProfileClickService.save(doctorProfileClickRequestDTO);
            return new ResponseEntity<>(optionalT, HttpStatus.OK);
        }
    }


}
