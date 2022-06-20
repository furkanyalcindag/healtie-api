package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.ContractDTO;
import com.comitfy.healtie.app.dto.requestDTO.ContractRequestDTO;
import com.comitfy.healtie.app.entity.Contract;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractMapper implements BaseMapper<ContractDTO, ContractRequestDTO, Contract> {
    @Override
    public ContractDTO entityToDTO(Contract entity) {
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setKey(entity.getKey());
        contractDTO.setTitle(entity.getTitle());
        contractDTO.setContent(entity.getContent());
        contractDTO.setRequired(entity.isRequired());
        contractDTO.setUuid(entity.getUuid());
        return contractDTO;

    }

    @Override
    public Contract dtoToEntity(ContractDTO dto) {
        Contract contract = new Contract();
        contract.setKey(dto.getKey());
        contract.setTitle(dto.getTitle());
        contract.setContent(dto.getContent());
        contract.setRequired(dto.isRequired());
        return contract;
    }

    @Override
    public Contract requestDTOToEntity(ContractRequestDTO dto) {
        Contract contract = new Contract();
        contract.setKey(dto.getKey());
        contract.setTitle(dto.getTitle());
        contract.setContent(dto.getContent());
        contract.setRequired(dto.isRequired());
        return contract;
    }

    @Override
    public Contract requestDTOToExistEntity(Contract contract, ContractRequestDTO dto) {

        contract.setKey(dto.getKey());
        contract.setTitle(dto.getTitle());
        contract.setContent(dto.getContent());
        contract.setRequired(dto.isRequired());
        return contract;
    }

    @Override
    public List<Contract> dtoListToEntityList(List<ContractDTO> contractDTOS) {
        List<Contract> contractList = new ArrayList<>();
        for (ContractDTO contractDTO : contractDTOS) {
            Contract contract = dtoToEntity(contractDTO);
            contractList.add(contract);
        }
        return contractList;
    }

    @Override
    public List<ContractDTO> entityListToDTOList(List<Contract> contracts) {
        List<ContractDTO> contractDTOList = new ArrayList<>();
        for (Contract contract : contracts) {
            ContractDTO contractDTO = entityToDTO(contract);
            contractDTOList.add(contractDTO);
        }
        return contractDTOList;
    }

    @Override
    public PageDTO<ContractDTO> pageEntityToPageDTO(Page<Contract> pageEntity) {
        PageDTO<ContractDTO> pageDTO = new PageDTO<ContractDTO>();
        List<Contract> entityList = pageEntity.toList();
        List<ContractDTO> contractDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, contractDTOList);
        return pageDTO;
    }
}
