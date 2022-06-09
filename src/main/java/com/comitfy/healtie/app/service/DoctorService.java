package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.DoctorDTO;
import com.comitfy.healtie.app.dto.requestDTO.DoctorRequestDTO;
import com.comitfy.healtie.app.entity.Doctor;
import com.comitfy.healtie.app.mapper.DoctorMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.ArticleRepository;
import com.comitfy.healtie.app.repository.DoctorRepository;
import com.comitfy.healtie.app.specification.DoctorSpecification;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService extends BaseService<DoctorDTO, DoctorRequestDTO, Doctor, DoctorRepository, DoctorMapper, DoctorSpecification> {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorSpecification doctorSpecification;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    public DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    public DoctorSpecification getSpecification() {
        return doctorSpecification;
    }


   /* public PageDTO<DoctorDTO> getDoctorById(UUID id, int page, int size, LanguageEnum languageEnum) {
        Optional<Doctor> doctor = doctorRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        if (doctor.isPresent()) {
            PageDTO<DoctorDTO> pageDTO = getMapper().pageEntityToPageDTO(getRepository().findAllByDoctor(pageable, doctor.get()));
            for (int i = 0; i < pageDTO.getData().size(); i++) {
                pageDTO.getData().get(i).setArticleLikeCount(getRepository().getCountOfArticles(pageDTO.getData().get(i).getUuid()));
            }
            return pageDTO;

        } else {
            return null;
        }
    }*/


}
