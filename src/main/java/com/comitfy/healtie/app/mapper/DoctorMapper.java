package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements BaseMapper<DoctorDTO, DoctorRequestDTO, Doctor> {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DoctorDTO entityToDTO(Doctor entity) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setTitle(entity.getTitle());
        doctorDTO.setDiplomaNo(entity.getDiplomaNo());
        doctorDTO.setAddress(entity.getAddress());
        doctorDTO.setPhone(entity.getPhone());
        doctorDTO.setClinicName(entity.getClinicName());
        doctorDTO.setUuid(entity.getUuid());
        doctorDTO.setBranch(entity.getBranch());
        doctorDTO.setAbout(entity.getAbout());
        doctorDTO.setLanguageEnum(entity.getLanguageEnum());

        doctorDTO.setFirstName(entity.getUser().getFirstName());
        doctorDTO.setLastName((entity.getUser().getLastName()));
        doctorDTO.setEmail(entity.getUser().getEmail());

        if (entity.getArticleList() != null) {
            doctorDTO.setArticleCount(entity.getArticleList().size());
        }
        return doctorDTO;

    }

    @Override
    public Doctor dtoToEntity(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setTitle(dto.getTitle());
        doctor.setDiplomaNo(dto.getDiplomaNo());
        doctor.setAddress(dto.getAddress());
        doctor.setPhone(dto.getPhone());
        doctor.setBranch(dto.getBranch());
        doctor.setAbout(dto.getAbout());
        doctor.setClinicName(dto.getClinicName());
        doctor.setLanguageEnum(dto.getLanguageEnum());

        return doctor;

    }

    @Override
    public Doctor requestDTOToEntity(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setTitle(dto.getTitle());
        doctor.setDiplomaNo(dto.getDiplomaNo());
        doctor.setAddress(dto.getAddress());
        doctor.setPhone(dto.getPhone());
        doctor.setBranch(dto.getBranch());
        doctor.setAbout(dto.getAbout());
        doctor.setClinicName(dto.getClinicName());
        doctor.setLanguageEnum(dto.getLanguageEnum());

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        doctor.setUser(user);


        return doctor;
    }

    @Override
    public Doctor requestDTOToExistEntity(Doctor doctor, DoctorRequestDTO dto) {
        doctor.setTitle(dto.getTitle());
        doctor.setDiplomaNo(dto.getDiplomaNo());
        doctor.setAddress(dto.getAddress());
        doctor.setPhone(dto.getPhone());
        doctor.setBranch(dto.getBranch());
        doctor.setAbout(dto.getAbout());
        doctor.setClinicName(dto.getClinicName());
        doctor.setLanguageEnum(dto.getLanguageEnum());

        return doctor;
    }

    @Override
    public List<Doctor> dtoListToEntityList(List<DoctorDTO> doctorDTOS) {
        List<Doctor> doctorList = new ArrayList<>();
        for (DoctorDTO doctorDTO : doctorDTOS) {
            Doctor doctor = dtoToEntity(doctorDTO);
            doctorList.add(doctor);
        }
        return doctorList;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<Doctor> doctors) {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorDTO doctorDTO = entityToDTO(doctor);
            doctorDTOList.add(doctorDTO);
        }
        return doctorDTOList;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<Doctor> pageEntity) {

        PageDTO<DoctorDTO> pageDTO = new PageDTO<DoctorDTO>();
        List<Doctor> entityList = pageEntity.toList();
        List<DoctorDTO> doctorDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, doctorDTOList);

        return pageDTO;
    }
}
