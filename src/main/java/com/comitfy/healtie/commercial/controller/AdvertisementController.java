package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.AdvertisementDTO;
import com.comitfy.healtie.commercial.dto.request.AdvertisementRequestDTO;
import com.comitfy.healtie.commercial.dto.request.CustomerAdvertisementOrderRequestDTO;
import com.comitfy.healtie.commercial.entity.Advertisement;
import com.comitfy.healtie.commercial.mapper.AdvertisementMapper;
import com.comitfy.healtie.commercial.repository.AdvertisementRepository;
import com.comitfy.healtie.commercial.service.AdvertisementService;
import com.comitfy.healtie.commercial.specification.AdvertisementSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("advertisement")
public class AdvertisementController extends BaseCrudController<AdvertisementDTO, AdvertisementRequestDTO, Advertisement, AdvertisementRepository, AdvertisementMapper, AdvertisementSpecification, AdvertisementService> {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    AdvertisementMapper advertisementMapper;

    @Autowired
    HelperService helperService;

    @Override
    protected AdvertisementService getService() {
        return advertisementService;
    }

    @Override
    protected AdvertisementMapper getMapper() {
        return advertisementMapper;
    }

    @PostMapping("/user-api")
    public ResponseEntity<AdvertisementRequestDTO> saveByUserID(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                @RequestBody AdvertisementRequestDTO advertisementRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(advertisementService.saveAdvertisementByUser(user.getUuid(), advertisementRequestDTO), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/{advertisementId}")
    public ResponseEntity<CustomerAdvertisementOrderRequestDTO> saveCustomerAdvertisement(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                                          @PathVariable UUID advertisementId, @RequestBody CustomerAdvertisementOrderRequestDTO dto) {

        Advertisement advertisement = advertisementService.findEntityByUUID(advertisementId);
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(advertisementService.saveCustomerAdvertisement(advertisement.getUuid(), dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/user-api/{advertisementId}")
    public ResponseEntity<String> updateAdvertisement(@PathVariable UUID advertisementId, @RequestBody AdvertisementRequestDTO dto) {
        User user = helperService.getUserFromSession();
        AdvertisementDTO advertisementDTO = advertisementService.findByUUID(advertisementId);

        if (advertisementDTO == null || user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);

        } else {
            advertisementService.updateAdvertisement(advertisementId, dto, user);
            return new ResponseEntity<>("The object was updated.", HttpStatus.OK);

        }
    }

}
