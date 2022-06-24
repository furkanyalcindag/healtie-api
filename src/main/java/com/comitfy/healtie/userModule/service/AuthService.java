package com.comitfy.healtie.userModule.service;


import com.comitfy.healtie.app.repository.UserContractRepository;
import com.comitfy.healtie.userModule.dto.ContractDTO;
import com.comitfy.healtie.userModule.dto.UserContractDTO;
import com.comitfy.healtie.userModule.entity.Contract;
import com.comitfy.healtie.userModule.entity.Role;
import com.comitfy.healtie.userModule.entity.User;
import com.comitfy.healtie.userModule.entity.UserContract;
import com.comitfy.healtie.userModule.mapper.ContractMapper;
import com.comitfy.healtie.userModule.model.requestModel.auth.RegisterRequest;
import com.comitfy.healtie.userModule.repository.ContractRepository;
import com.comitfy.healtie.userModule.repository.RoleRepository;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.userModule.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService implements IAuthService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    ContractRepository contractRepository;

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserContractRepository userContractRepository;


    @Override
    public boolean registerUser(RegisterRequest request) {

        Optional<User> user = userRepository.findByEmail(request.getEmail());

        //Gender gender = genderService.findEntityByUUID(request.getGenderUUID());


        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(request.getEmail());
            newUser.setUsername(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setFirstName(request.getFirstName());
            newUser.setLastName(request.getLastName());
            newUser.setAgeRangeEnum(request.getAgeRangeEnum());
            newUser.setGenderEnum(request.getGenderEnum());





            // newUser.setGender(gender);

            // doctorDTO.setFirstName(entity.getUser().getFirstName());

            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("user").get());
            newUser.setRoles(roles);

            userRepository.save(newUser);

            UserContract userContract = new UserContract();
            for (UserContractDTO contractDTO:request.getContractDTOList()) {
                userContract.setContractUuid(contractDTO.getContractUuid());
                userContract.setUserUuid(newUser.getUuid());
                userContract.setSigned(contractDTO.isSigned());
            }
            userContractRepository.save(userContract);

            return true;

        } else {


            throw new ResourceNotFoundException("email is exist = " + request.getEmail());

        }

    }

    @Override
    public boolean isValidateUserContracts(List<UserContractDTO> contractDTOList) {
        boolean x = true;

        for (UserContractDTO contractDTO : contractDTOList) {

            Optional<Contract> optional = contractRepository.findByUuid(contractDTO.getContractUuid());
            if (optional.isPresent()) {
                Contract contract = optional.get();

                if (contract.getRequired() && !contractDTO.isSigned()) {
                    x = false;
                    break;
                }
            }
        }
        return x;
    }

/*    public void addContractToUser(UserContractDTO userContractDTO) {
        //   Optional<User> user1 = userRepository.findByUuid(user.getUuid());
        UserContract userContract = new UserContract();
        userContract.setContractUuid(userContractDTO.getContractUuid());
        userContract.setUserUuid(userContractDTO.getRequestUserUUID());
        userContract.setSigned(userContractDTO.isSigned());
        userContractRepository.save(userContract);


    }*/

    /*
    Set<Category> parentList = new HashSet<>();
        category.setParent(parentList);
        for (UUID uuid : dto.getParentList()) {
            Optional<Category> category1 = categoryRepository.findByUuid(uuid);

            category1.ifPresent(value -> category.getParent().add(value));
        }

    public PageDTO<ArticleDTO> getLikedArticleByUser(int page, int size, User user,LanguageEnum languageEnum) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));

        PageDTO<ArticleDTO> pageDTO = getMapper().pageEntityToPageDTO(getRepository().findAllByUser(pageable, user,languageEnum));

        for (ArticleDTO articleDTO : pageDTO.getData()) {
            articleDTO.setLike(isLikedArticleByUser(articleDTO.getUuid(), user.getUuid()));
            articleDTO.setSave(isSavedArticleByUser(articleDTO.getUuid(), user.getUuid()));
            articleDTO.setCommentCount(getRepository().getCountOfComment(articleDTO.getUuid()));
        }
        return getMapper().pageEntityToPageDTO(articleRepository.getLikedArticleOfUser(pageable, user.getUuid()));

    }

      for (Tag tag : entity.getTags()) {

            TagDTO tagDTO = new TagDTO();
            tagDTO.setName(tag.getName());
            tagDTO.setUuid(tag.getUuid());
            tagDTOS.add(tagDTO);
        }
*/
}
