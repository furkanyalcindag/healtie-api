package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.ContractActiveDTO;
import com.comitfy.healtie.app.dto.ContractDTO;
import com.comitfy.healtie.app.dto.requestDTO.ContractRequestDTO;
import com.comitfy.healtie.app.entity.Contract;
import com.comitfy.healtie.app.mapper.ContractMapper;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.app.repository.ContractRepository;
import com.comitfy.healtie.app.specification.ContractSpecification;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService extends BaseService<ContractDTO, ContractRequestDTO, Contract, ContractRepository, ContractMapper, ContractSpecification> {

    @Autowired
    ContractRepository contractRepository;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    ContractSpecification contractSpecification;

    @Autowired
    UserRepository userRepository;

    @Override
    public ContractRepository getRepository() {
        return contractRepository;
    }

    @Override
    public ContractMapper getMapper() {
        return contractMapper;
    }

    @Override
    public ContractSpecification getSpecification() {
        return contractSpecification;
    }

    public ContractRequestDTO saveContractByUser(UUID id, ContractRequestDTO dto, LanguageEnum languageEnum) {
        Optional<User> user = userRepository.findByUuid(id);
        if (user.isPresent()) {
            Contract contract = getMapper().requestDTOToEntity(dto);
            contract.setLanguageEnum(languageEnum);
            contractRepository.save(contract);
            return dto;
        } else {
            return null;
        }
    }

    public PageDTO<ContractActiveDTO> getActiveContract(UUID id, int page, int size, LanguageEnum languageEnum) {
        Optional<User> user = userRepository.findByUuid(id);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));
        if (user.isPresent()) {
            PageDTO<ContractActiveDTO> pageDTO = contractMapper.pageActiveEntityToPageDTO(contractRepository.findAllByActivatedAndLanguageEnum(pageable, true, languageEnum));

            return pageDTO;
        } else {
            return null;
        }
    }


}
