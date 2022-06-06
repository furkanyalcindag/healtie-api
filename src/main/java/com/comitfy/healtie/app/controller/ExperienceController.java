package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.ExperienceDTO;
import com.comitfy.healtie.app.dto.requestDTO.ExperienceRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.entity.Experience;
import com.comitfy.healtie.app.mapper.ExperienceMapper;
import com.comitfy.healtie.app.repository.ExperienceRepository;
import com.comitfy.healtie.app.service.DoctorService;
import com.comitfy.healtie.app.service.ExperienceService;
import com.comitfy.healtie.app.specification.ExperienceSpecification;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("experience")
public class ExperienceController extends BaseCrudController<ExperienceDTO, ExperienceRequestDTO, Experience, ExperienceRepository, ExperienceMapper, ExperienceSpecification, ExperienceService> {

    @Autowired
    ExperienceService experienceService;

    @Autowired
    ExperienceMapper experienceMapper;

    @Autowired
    DoctorService doctorService;

    @Override
    protected ExperienceService getService() {
        return experienceService;
    }

    @Override
    protected ExperienceMapper getMapper() {
        return experienceMapper;
    }

    @PostMapping("/{doctorId}")
    public ResponseEntity<ExperienceRequestDTO> saveByDoctorId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                               @PathVariable UUID doctorId, @RequestBody ExperienceRequestDTO experienceRequestDTO) {
        DoctorDTO optional = doctorService.findByUUID(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(experienceService.saveExperienceByDoctor(doctorId, experienceRequestDTO), HttpStatus.OK);
        }
    }


    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<PageDTO<ExperienceDTO>> getByDoctorId(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                @PathVariable UUID doctorId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Optional<Doctor> optional = doctorService.getRepository().findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(experienceService.getExperienceByDoctor(doctorId, pageNumber, pageSize), HttpStatus.OK);
        }
    }
}
