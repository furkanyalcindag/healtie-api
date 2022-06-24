package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.userModule.dto.UserContractDTO;
import com.comitfy.healtie.userModule.dto.requestDTO.UserContractRequestDTO;
import com.comitfy.healtie.userModule.entity.UserContract;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserContractMapper implements BaseMapper<UserContractDTO, UserContractRequestDTO, UserContract> {
    @Override
    public UserContractDTO entityToDTO(UserContract entity) {
        UserContractDTO userContractDTO = new UserContractDTO();
        userContractDTO.setUuid(entity.getUuid());
      //  userContractDTO.setContractUuid(entity.getContractUuid());
        //userContractDTO.setUserUuid(entity.getUserUuid());
        userContractDTO.setSigned(entity.isSigned());
        return userContractDTO;

    }


    @Override
    public UserContract dtoToEntity(UserContractDTO dto) {
        UserContract userContract = new UserContract();
      //  userContract.setContractUuid(dto.getContractUuid());
        return userContract;
    }

    @Override
    public UserContract requestDTOToEntity(UserContractRequestDTO dto) {
        UserContract userContract = new UserContract();
        userContract.setContractUuid(dto.getContractUuid());
        return userContract;
    }

    @Override
    public UserContract requestDTOToExistEntity(UserContract entity, UserContractRequestDTO dto) {

        entity.setContractUuid(dto.getContractUuid());
        return entity;
    }

    @Override
    public List<UserContract> dtoListToEntityList(List<UserContractDTO> userContractDTOS) {
        List<UserContract> userContractList = new ArrayList<>();
        for (UserContractDTO userContractDTO : userContractDTOS) {
            UserContract contract = dtoToEntity(userContractDTO);
            userContractList.add(contract);
        }
        return userContractList;
    }

    @Override
    public List<UserContractDTO> entityListToDTOList(List<UserContract> userContracts) {
        List<UserContractDTO> userContractDTOList = new ArrayList<>();
        for (UserContract userContract : userContracts) {
            UserContractDTO userContractDTO = entityToDTO(userContract);
            userContractDTOList.add(userContractDTO);
        }
        return userContractDTOList;
    }

    @Override
    public PageDTO<UserContractDTO> pageEntityToPageDTO(Page<UserContract> pageEntity) {
        PageDTO<UserContractDTO> pageDTO = new PageDTO<UserContractDTO>();
        List<UserContract> entityList = pageEntity.toList();
        List<UserContractDTO> userContractDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, userContractDTOList);
        return pageDTO;

}
}
