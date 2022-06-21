package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.ContractActiveDTO;
import com.comitfy.healtie.app.dto.ContractDTO;
import com.comitfy.healtie.app.dto.requestDTO.ContractRequestDTO;
import com.comitfy.healtie.app.entity.Contract;
import com.comitfy.healtie.app.mapper.ContractMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.ContractRepository;
import com.comitfy.healtie.app.service.ContractService;
import com.comitfy.healtie.app.specification.ContractSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contract")
public class ContractController extends BaseCrudController<ContractDTO, ContractRequestDTO, Contract, ContractRepository, ContractMapper, ContractSpecification, ContractService> {
    @Autowired
    ContractService contractService;
    @Autowired
    ContractMapper contractMapper;

    @Autowired
    HelperService helperService;

    @Override
    protected ContractService getService() {
        return contractService;
    }

    @Override
    protected ContractMapper getMapper() {
        return contractMapper;
    }

    @PostMapping("/user-api")
    public ResponseEntity<ContractRequestDTO> saveByUserId(@RequestHeader(value = "accept-language", required = true) String language,
                                                           @RequestBody ContractRequestDTO contractRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            {
                return new ResponseEntity<>(contractService.saveContractByUser(user.getUuid(), contractRequestDTO, LanguageEnum.valueOf(language)), HttpStatus.OK);
            }
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("user-api/active-contract/")
    public ResponseEntity<PageDTO<ContractActiveDTO>> getActiveContract(@RequestHeader(value = "accept-language", required = true) String language,
                                                                        @RequestParam int pageNumber, @RequestParam int pageSize) {
        User user = helperService.getUserFromSession();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PageDTO<ContractActiveDTO> dto = contractService.getActiveContract(user.getUuid(), pageNumber, pageSize, LanguageEnum.valueOf(language));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }

}