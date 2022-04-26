package com.comitfy.healtie.util.common;

import com.comitfy.healtie.app.dto.requestDTO.LanguageRequestDTO;
import com.comitfy.healtie.app.entity.Language;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseMapper<DTO extends BaseDTO, RequestDTO extends BaseDTO, Entity extends BaseEntity> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> pageEntity);


}
