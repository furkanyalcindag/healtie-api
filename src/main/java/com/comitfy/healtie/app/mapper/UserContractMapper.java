package com.comitfy.healtie.app.mapper;

import com.comitfy.healtie.app.dto.UserContractDTO;
import com.comitfy.healtie.app.dto.requestDTO.UserContractRequestDTO;
import com.comitfy.healtie.app.entity.UserContract;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserContractMapper implements BaseMapper<UserContractDTO, UserContractRequestDTO, UserContract> {
    @Override
    public UserContractDTO entityToDTO(UserContract entity) {
        UserContractDTO userContractDTO = new UserContractDTO();
        userContractDTO.setUuid(entity.getUuid());
        userContractDTO.setContractUuid(entity.getContractUuid());
        userContractDTO.setUserUuid(entity.getUserUuid());
        userContractDTO.setSigned(entity.isSigned());
        return userContractDTO;

    }

        /*  Set<TagDTO> tagDTOS = new HashSet<>();
        for (Tag tag : entity.getTags()) {

            TagDTO tagDTO = new TagDTO();
            tagDTO.setName(tag.getName());
            tagDTO.setUuid(tag.getUuid());
            tagDTOS.add(tagDTO);
        }

        articleDTO.setTags(tagDTOS);
           for (UUID uuid : dto.getCategoryList()) {
            Optional<Category> category1 = categoryRepository.findByUuid(uuid);

            category1.ifPresent(value -> article.getCategoryList().add(value));
        } for (ArticleClick articleClick : articleClickEntity) {
            ArticleClickDTO articleClickDTO = entityToDTO(articleClick);
            articleClickDTOList.add(articleClickDTO);
        }

         */


    @Override
    public UserContract dtoToEntity(UserContractDTO dto) {
        return null;
    }

    @Override
    public UserContract requestDTOToEntity(UserContractRequestDTO dto) {
        return null;
    }

    @Override
    public UserContract requestDTOToExistEntity(UserContract entity, UserContractRequestDTO dto) {
        return null;
    }

    @Override
    public List<UserContract> dtoListToEntityList(List<UserContractDTO> userContractDTOS) {
        return null;
    }

    @Override
    public List<UserContractDTO> entityListToDTOList(List<UserContract> userContracts) {
        return null;
    }

    @Override
    public PageDTO<UserContractDTO> pageEntityToPageDTO(Page<UserContract> pageEntity) {
        return null;
    }
}
