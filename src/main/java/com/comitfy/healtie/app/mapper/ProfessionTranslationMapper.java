package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ProfessionTranslationDTO;
import com.comitfy.healtie.app.dto.requestDTO.ProfessionTranslationRequestDTO;
import com.comitfy.healtie.app.entity.ProfessionTranslation;
import com.comitfy.healtie.app.service.ProfessionService;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessionTranslationMapper implements BaseMapper<ProfessionTranslationDTO, ProfessionTranslationRequestDTO, ProfessionTranslation> {

    @Autowired
    ProfessionService professionService;

    @Override
    public ProfessionTranslationDTO entityToDTO(ProfessionTranslation entity) {
        ProfessionTranslationDTO professionTranslationDTO=new ProfessionTranslationDTO();
        professionTranslationDTO.setName(entity.getName());
        professionTranslationDTO.setLanguageEnum(entity.getLanguageEnum());
        return professionTranslationDTO;
    }

    @Override
    public ProfessionTranslation dtoToEntity(ProfessionTranslationDTO dto) {
      ProfessionTranslation professionTranslation=new ProfessionTranslation();
      professionTranslation.setName(dto.getName());
      professionTranslation.setLanguageEnum(dto.getLanguageEnum());
      professionTranslation.setUuid(dto.getUuid());
      return professionTranslation;
    }

    @Override
    public ProfessionTranslation requestDTOToEntity(ProfessionTranslationRequestDTO dto) {
        ProfessionTranslation professionTranslation=new ProfessionTranslation();
        professionTranslation.setName(dto.getName());
        professionTranslation.setLanguageEnum(dto.getLanguageEnum());
        professionTranslation.setProfession(professionService.getRepository().findByUuid(dto.getUuid()).get());
        return professionTranslation;
    }

    @Override
    public ProfessionTranslation requestDTOToExistEntity(ProfessionTranslation professionTranslation, ProfessionTranslationRequestDTO dto) {
        professionTranslation.setName(dto.getName());
        professionTranslation.setLanguageEnum(dto.getLanguageEnum());
        //professionTranslation.setUuid(dto.getUuid());
        return professionTranslation;
    }

    @Override
    public List<ProfessionTranslation> dtoListToEntityList(List<ProfessionTranslationDTO> professionTranslationDTOS) {
        List<ProfessionTranslation> professionTranslationList = new ArrayList<>();
        for (ProfessionTranslationDTO professionTranslationDTO : professionTranslationDTOS) {
            ProfessionTranslation professionTranslation = dtoToEntity(professionTranslationDTO);
            professionTranslationList.add(professionTranslation);
        }
        return professionTranslationList;
    }

    @Override
    public List<ProfessionTranslationDTO> entityListToDTOList(List<ProfessionTranslation> professionTranslations) {
   List<ProfessionTranslationDTO> professionTranslationDTOList=new ArrayList<>();
   for (ProfessionTranslation professionTranslation:professionTranslations){
       ProfessionTranslationDTO professionTranslationDTO=entityToDTO(professionTranslation);
       professionTranslationDTOList.add(professionTranslationDTO);
   }return professionTranslationDTOList;
    }

    @Override
    public PageDTO<ProfessionTranslationDTO> pageEntityToPageDTO(Page<ProfessionTranslation> pageEntity) {
        PageDTO<ProfessionTranslationDTO> pageDTO = new PageDTO<ProfessionTranslationDTO>();
        List<ProfessionTranslation> entityList = pageEntity.toList();
        List<ProfessionTranslationDTO> professionTranslationDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, professionTranslationDTOList);

        return pageDTO;
    }
}
