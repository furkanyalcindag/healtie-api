package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.AcademicInfoDTO;
import com.comitfy.healtie.app.dto.requestDTO.AcademicInfoRequestDTO;
import com.comitfy.healtie.app.entity.AcademicInfo;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.AcademicInfoMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.AcademicInfoRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.service.AcademicInfoService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("academicInfo")
public class AcademicInfoController extends BaseCrudController<AcademicInfoDTO, AcademicInfoRequestDTO, AcademicInfo, AcademicInfoRepository, AcademicInfoMapper, AcademicInfoService> {

    @Autowired
    AcademicInfoService academicInfoService;

    @Autowired
    AcademicInfoMapper academicInfoMapper;

    @Override
    protected AcademicInfoService getService() {
        return academicInfoService;
    }

    @Override
    protected AcademicInfoMapper getMapper() {
        return academicInfoMapper;
    }

    @Autowired
    AcademicInfoRepository academicInfoRepository;

    @Autowired
    DoctorRepository doctorRepository;


    @PostMapping("/{doctorId}")
    public ResponseEntity<AcademicInfoRequestDTO> save(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                       @PathVariable UUID doctorId, @RequestBody AcademicInfoRequestDTO academicInfoRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(academicInfoService.saveFromDoctor(doctorId, academicInfoRequestDTO), HttpStatus.OK);
        }
    }


/*   @PutMapping("/{doctorId}")
    public ResponseEntity<String> update(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                         @PathVariable UUID doctorId, @RequestBody AcademicInfoRequestDTO academicInfoRequestDTO) {
        Optional<Doctor> optional = doctorRepository.findByUuid(doctorId);
        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            academicInfoRequestDTO.setLanguageEnum(LanguageEnum.valueOf(acceptLanguage));
            getService().update(doctorId, academicInfoRequestDTO);
            return new ResponseEntity<>("Doctor with the id " + doctorId + " was updated.", HttpStatus.OK);
        }
    }*/


}


 /*   Certificate certificate = getMapper().requestDTOToEntity(dto);
            certificate.setDoctor(doctor.get());*/

//   return new ResponseEntity<>(getService().save(academicInfoRequestDTO), HttpStatus.CREATED);
//  academicInfoRequestDTO.setDoctor();
// return new ResponseEntity<>(HttpStatus.OK);


     /*  @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestHeader(value = "accept-language", required = true) String acceptLanguage, @PathVariable UUID id, @RequestBody RequestDTO body) {
        DTO optional = getService().findByUUID(id);

        if (optional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        } else {
            body.setLanguageEnum(LanguageEnum.valueOf(acceptLanguage));
            getService().update(id, body);
            return new ResponseEntity<>("Object with the id " + id + " was updated.", HttpStatus.OK);
        }*/


/*    @PostMapping("/doctorId")
    public AcademicInfo createAcademicInfo(@PathVariable(value = "doctorId") UUID uuid, @RequestParam AcademicInfo academicInfo) {
        List<AcademicInfo> academicInfoList = new ArrayList<>();
        academicInfoList.add(academicInfo);
        academicInfo.setDoctor(this);
    }*/


/*    @GetMapping("/{id}")
    public ResponseEntity<Optional<AcademicInfo>> findAllAcademicInfoByDoctorId(@PathVariable(value = "id") Long doctorID) {
        Optional<AcademicInfo> academicInfo = academicInfoRepository.findById(doctorID);
        if (academicInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(academicInfo);
    }*/


