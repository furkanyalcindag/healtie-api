package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.commercial.dto.AdvertisementDTO;
import com.comitfy.healtie.commercial.dto.request.AdvertisementRequestDTO;
import com.comitfy.healtie.commercial.entity.Advertisement;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdvertisementMapper implements BaseMapper<AdvertisementDTO, AdvertisementRequestDTO, Advertisement> {

    @Override
    public AdvertisementDTO entityToDTO(Advertisement entity) {
        AdvertisementDTO advertisementDTO = new AdvertisementDTO();
        advertisementDTO.setLocation(entity.getLocation());
        advertisementDTO.setHeight(entity.getHeight());
        advertisementDTO.setWidth(entity.getWidth());
        advertisementDTO.setPrice(entity.getPrice());
        advertisementDTO.setUuid(entity.getUuid());
        advertisementDTO.setLanguage(entity.getLanguageEnum().name());

        advertisementDTO.setTotalPrice((entity.getPrice()) + ((entity.getPrice() * (entity.getTaxRatio()) / 100)));

        return advertisementDTO;
    }

    @Override
    public Advertisement dtoToEntity(AdvertisementDTO dto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setLocation(dto.getLocation());
        advertisement.setHeight(dto.getHeight());
        advertisement.setWidth(dto.getWidth());
        advertisement.setPrice(dto.getPrice());
        advertisement.setLanguageEnum(LanguageEnum.valueOf(dto.getLanguage()));
        return advertisement;

    }

    @Override
    public Advertisement requestDTOToEntity(AdvertisementRequestDTO dto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setLocation(dto.getLocation());
        advertisement.setHeight(dto.getHeight());
        advertisement.setWidth(dto.getWidth());
        advertisement.setPrice(dto.getPrice());
        advertisement.setTaxRatio(dto.getTaxRatio());
        advertisement.setLanguageEnum(LanguageEnum.valueOf(dto.getLanguage()));
        return advertisement;
    }

    @Override
    public Advertisement requestDTOToExistEntity(Advertisement advertisement, AdvertisementRequestDTO dto) {

        advertisement.setLocation(dto.getLocation());
        advertisement.setHeight(dto.getHeight());
        advertisement.setWidth(dto.getWidth());
        advertisement.setPrice(dto.getPrice());
        advertisement.setTaxRatio(dto.getTaxRatio());
        advertisement.setLanguageEnum(LanguageEnum.valueOf(dto.getLanguage()));
        return advertisement;
    }

    @Override
    public List<Advertisement> dtoListToEntityList(List<AdvertisementDTO> advertisementDTOS) {
        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
        for (AdvertisementDTO advertisementDTO : advertisementDTOS) {
            Advertisement advertisement = dtoToEntity(advertisementDTO);
            advertisementList.add(advertisement);
        }
        return advertisementList;
    }

    @Override
    public List<AdvertisementDTO> entityListToDTOList(List<Advertisement> advertisements) {
        List<AdvertisementDTO> advertisementDTOList = new ArrayList<>();
        for (Advertisement advertisement : advertisements) {
            AdvertisementDTO advertisementDTO = entityToDTO(advertisement);
            advertisementDTOList.add(advertisementDTO);
        }
        return advertisementDTOList;
    }

    @Override
    public PageDTO<AdvertisementDTO> pageEntityToPageDTO(Page<Advertisement> pageEntity) {
        PageDTO<AdvertisementDTO> pageDTO = new PageDTO<AdvertisementDTO>();
        List<Advertisement> entityList = pageEntity.toList();
        List<AdvertisementDTO> advertisementDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, advertisementDTOList);

        return pageDTO;
    }
}
