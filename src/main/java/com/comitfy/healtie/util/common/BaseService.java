package com.comitfy.healtie.util.common;

import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<DTO extends BaseDTO, Entity extends BaseEntity, Repository extends BaseRepository<Entity>, Mapper extends BaseMapper<DTO, Entity>> {


    public abstract Repository getRepository();

    public abstract Mapper getMapper();


    PageDTO<DTO> findAll(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return getMapper().pageEntityToPageDTO(getRepository().findAll(pageable));
    }

    DTO findByUUID(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        return optionalEntity.map(entity -> getMapper().entityToDTO(entity)).orElse(null);
    }

    DTO save(DTO dto) {
        Entity entity = getMapper().dtoToEntity(dto);
        getRepository().save(entity);
        return dto;
    }

    void delete(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        optionalEntity.ifPresent(entity -> getRepository().delete(entity));
    }

    DTO update(UUID id, DTO dto) {
        Entity entity = getMapper().dtoToEntity(dto);
        entity.setUuid(id);
        getRepository().save(entity);
        return dto;
    }


}
