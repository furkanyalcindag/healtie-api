package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.AdvertisementDTO;
import com.comitfy.healtie.commercial.dto.request.AdvertisementRequestDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerAdvertisementOrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Advertisement;
import com.comitfy.healtie.commercial.mapper.AdvertisementMapper;
import com.comitfy.healtie.commercial.repository.AdvertisementRepository;
import com.comitfy.healtie.commercial.repository.CustomerAdvertisementOrderRepository;
import com.comitfy.healtie.commercial.specification.AdvertisementSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdvertisementService extends BaseService<AdvertisementDTO, AdvertisementRequestDTO, Advertisement, AdvertisementRepository, AdvertisementMapper, AdvertisementSpecification> {

    @Autowired
    AdvertisementRepository advertisementRepository;
    @Autowired
    AdvertisementMapper advertisementMapper;
    @Autowired
    AdvertisementSpecification advertisementSpecification;
    @Autowired
    CustomerAdvertisementOrderRepository customerAdvertisementOrderRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public AdvertisementRepository getRepository() {
        return advertisementRepository;
    }

    @Override
    public AdvertisementMapper getMapper() {
        return advertisementMapper;
    }

    @Override
    public AdvertisementSpecification getSpecification() {
        return advertisementSpecification;
    }


    public AdvertisementRequestDTO saveAdvertisementByUser(UUID id, AdvertisementRequestDTO dto) {
        Optional<User> user = userRepository.findByUuid(id);
        if (user.isPresent()) {
            Advertisement advertisement = getMapper().requestDTOToEntity(dto);
            advertisementRepository.save(advertisement);

            return dto;
        } else {
            return null;
        }

    }

    public CustomerAdvertisementOrderRequestDTO saveCustomerAdvertisement(UUID advertisementId, CustomerAdvertisementOrderRequestDTO dto) {
        Optional<Advertisement> advertisement = advertisementRepository.findByUuid(advertisementId);
        if (advertisement.isPresent()) {
            // dto.setCustomerUUID(customer.getUuid());
            dto.setAdvertisementUUID(advertisement.get().getUuid());
            dto.setPrice(advertisement.get().getPrice());

            return dto;

        } else return null;
    }

    public AdvertisementRequestDTO updateAdvertisement(UUID id, AdvertisementRequestDTO dto, User user) {
        Optional<Advertisement> advertisement = advertisementRepository.findByUuid(id);
        if (advertisement.isPresent()) {
            Advertisement advertisement1 = advertisementMapper.requestDTOToExistEntity(advertisement.get(), dto);
            advertisementRepository.save(advertisement1);
            return dto;
        } else {
            return null;
        }

    }
}
