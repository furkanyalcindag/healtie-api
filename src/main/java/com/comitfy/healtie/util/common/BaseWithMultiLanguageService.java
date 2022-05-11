package com.comitfy.healtie.util.common;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.dbUtil.BaseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.UUID;

public abstract class BaseWithMultiLanguageService<DTO extends BaseDTO, RequestDTO extends BaseDTO, Entity extends BaseEntity, Repository extends BaseWithMultiLanguageRepository<Entity>, Mapper extends BaseMapper<DTO, RequestDTO, Entity>> {


    public abstract Repository getRepository();

    public abstract Mapper getMapper();


    public PageDTO<DTO> findAll(int page, int size, LanguageEnum languageEnum) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return getMapper().pageEntityToPageDTO(getRepository().findAllByLanguageEnum(pageable,languageEnum));
    }

    public DTO findByUUID(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        return optionalEntity.map(entity -> getMapper().entityToDTO(entity)).orElse(null);
    }

    public RequestDTO save(RequestDTO dto) {
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return dto;
    }

    void delete(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        if (optionalEntity.isPresent()) {
            Entity e = optionalEntity.get();
            e.setDeleted(true);
            /*Entity e = optionalEntity.get();
            e.setDeleted(true);
            getRepository().save(e);*/
            getRepository().save(e);
        }

    }

    public RequestDTO update(UUID id, RequestDTO dto) {
        Optional<Entity> entity = getRepository().findByUuid(id);

        if (entity.isPresent()) {
            Entity entity1 = getMapper().requestDTOToExistEntity(entity.get(), dto);
            getRepository().save(entity1);
            return dto;
        } else {
            return null;
        }


    }


}
