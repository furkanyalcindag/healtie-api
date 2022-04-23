package com.comitfy.healtie.util.common;

import com.comitfy.healtie.util.dbUtil.BaseEntity;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<DTO extends BaseDTO, Entity extends BaseEntity, Repository extends BaseRepository<Entity>, Mapper extends BaseMapper<DTO, Entity>> {


    public abstract Repository getRepository();

    public abstract Mapper getMapper();


    List<DTO> findAll() {
        return getMapper().entityListToDTOList(getRepository().findAll());
    }

    DTO findById(Long id) {
        Optional<Entity> optionalEntity = getRepository().findById(id);
        return optionalEntity.map(entity -> getMapper().entityToDTO(entity)).orElse(null);
    }

    DTO save(DTO dto) {
        Entity entity = getMapper().dtoToEntity(dto);
        getRepository().save(entity);
        return dto;
    }

    void delete(Long id) {
        Optional<Entity> optionalEntity = getRepository().findById(id);
        optionalEntity.ifPresent(entity -> getRepository().delete(entity));

    }

    DTO update(Long id, DTO dto) {
        Entity entity = getMapper().dtoToEntity(dto);
        entity.setId(id);
        getRepository().save(entity);
        return dto;
    }


}
