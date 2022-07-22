package com.comitfy.healtie.femaleModules.controller;

import com.comitfy.healtie.femaleModules.dto.PreferenceDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.PreferenceRequestDTO;
import com.comitfy.healtie.femaleModules.entity.Preference;
import com.comitfy.healtie.femaleModules.mapper.PreferenceMapper;
import com.comitfy.healtie.femaleModules.repository.PreferenceRepository;
import com.comitfy.healtie.femaleModules.service.PreferenceService;
import com.comitfy.healtie.femaleModules.specification.PreferenceSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("preference")
public class PreferenceController extends BaseCrudController<PreferenceDTO, PreferenceRequestDTO, Preference, PreferenceRepository, PreferenceMapper, PreferenceSpecification, PreferenceService> {
    @Autowired
    PreferenceService preferenceService;
    @Autowired
    PreferenceMapper preferenceMapper;

    @Autowired
    HelperService helperService;

    @Override
    protected PreferenceService getService() {
        return preferenceService;
    }

    @Override
    protected PreferenceMapper getMapper() {
        return preferenceMapper;
    }

    @PostMapping("/user-api")
    public ResponseEntity<PreferenceRequestDTO> saveByUserId(@RequestHeader(value = "accept-language", required = true) String language,
                                                             @RequestBody PreferenceRequestDTO preferenceRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(preferenceService.savePreferenceByUser(user.getUuid(), preferenceRequestDTO), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
