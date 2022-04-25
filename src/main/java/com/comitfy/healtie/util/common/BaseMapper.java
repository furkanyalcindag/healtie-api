package com.comitfy.healtie.util.common;

import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> pageEntity);


}
