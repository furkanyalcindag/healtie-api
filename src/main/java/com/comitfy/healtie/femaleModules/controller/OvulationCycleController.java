package com.comitfy.healtie.femaleModules.controller;

import com.comitfy.healtie.femaleModules.dto.OvulationCycleDTO;
import com.comitfy.healtie.femaleModules.dto.requestDTO.OvulationCycleRequestDTO;
import com.comitfy.healtie.femaleModules.entity.OvulationCycle;
import com.comitfy.healtie.femaleModules.mapper.OvulationCycleMapper;
import com.comitfy.healtie.femaleModules.repository.OvulationCycleRepository;
import com.comitfy.healtie.femaleModules.service.OvulationCycleService;
import com.comitfy.healtie.femaleModules.service.PreferenceService;
import com.comitfy.healtie.femaleModules.specification.OvulationCycleSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ovulation-cycle")
public class OvulationCycleController extends BaseCrudController<OvulationCycleDTO, OvulationCycleRequestDTO, OvulationCycle, OvulationCycleRepository, OvulationCycleMapper, OvulationCycleSpecification, OvulationCycleService> {
    @Autowired
    OvulationCycleService ovulationCycleService;
    @Autowired
    OvulationCycleMapper ovulationCycleMapper;

    @Autowired
    PreferenceService preferenceService;

    @Autowired
    HelperService helperService;

    @Override
    protected OvulationCycleService getService() {
        return ovulationCycleService;
    }

    @Override
    protected OvulationCycleMapper getMapper() {
        return ovulationCycleMapper;
    }

    @PostMapping("/user-api-activate")
    public ResponseEntity<OvulationCycleRequestDTO> saveByUser(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                                 @RequestBody OvulationCycleRequestDTO ovulationCycleRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(ovulationCycleService.saveOvulationCycleByUser(user, ovulationCycleRequestDTO), HttpStatus.OK);

        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("user-api/fertility-level")
    public ResponseEntity<OvulationCycleDTO> getFertilityLevelByUser(@RequestHeader(value = "accept-language", required = true) String language,
                                                                             @RequestParam int pageNumber, @RequestParam int pageSize) {
        User user = helperService.getUserFromSession();
        if (user != null) {

           return new ResponseEntity<>(ovulationCycleService.getActiveOvulationCycle(user),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
