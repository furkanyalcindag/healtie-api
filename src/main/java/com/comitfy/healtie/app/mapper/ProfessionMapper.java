package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ProfessionDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionRequestDTO;
import com.comitfy.healtie.app.entity.Profession;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionMapper implements BaseMapper<ProfessionDTO, ProfessionRequestDTO, Profession> {
    @Override
    public ProfessionDTO entityToDTO(Profession entity) {

        ProfessionDTO professionDTO = new ProfessionDTO();
        professionDTO.setKeyword(entity.getKeyword());
        professionDTO.setLanguageEnum(entity.getLanguageEnum());

        return professionDTO;
    }

    @Override
    public Profession dtoToEntity(ProfessionDTO dto) {

        Profession profession = new Profession();
        profession.setKeyword(dto.getKeyword());
        profession.setUuid(dto.getUuid());
        profession.setLanguageEnum(dto.getLanguageEnum());
        return profession;
    }

    @Override
    public Profession requestDTOToEntity(ProfessionRequestDTO dto) {

        Profession profession = new Profession();
        profession.setKeyword(dto.getKeyword());
        profession.setLanguageEnum(dto.getLanguageEnum());

        return profession;
    }

    @Override
    public Profession requestDTOToExistEntity(Profession profession, ProfessionRequestDTO dto) {

        profession.setKeyword(dto.getKeyword());
        profession.setLanguageEnum(dto.getLanguageEnum());
        return profession;
    }

    @Override
    public List<Profession> dtoListToEntityList(List<ProfessionDTO> professionDTOS) {
        List<Profession> professionsList = new ArrayList<>();
        for (ProfessionDTO professionDTo : professionDTOS) {
            Profession profession = dtoToEntity(professionDTo);
            professionsList.add(profession);
        }
        return professionsList;
    }

    @Override
    public List<ProfessionDTO> entityListToDTOList(List<Profession> professions) {
        List<ProfessionDTO> professionDTOList = new ArrayList<>();
        for (Profession profession : professions) {
            ProfessionDTO professionDTO = entityToDTO(profession);
            professionDTOList.add(professionDTO);
        }
        return professionDTOList;
    }

    @Override
    public PageDTO<ProfessionDTO> pageEntityToPageDTO(Page<Profession> pageEntity) {
        PageDTO<ProfessionDTO> pageDTO = new PageDTO<ProfessionDTO>();
        List<Profession> entityList = pageEntity.toList();
        List<ProfessionDTO> professionDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, professionDTOList);

        return pageDTO;
    }
}
