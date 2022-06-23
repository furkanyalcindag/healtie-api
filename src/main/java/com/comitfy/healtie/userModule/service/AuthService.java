package com.comitfy.healtie.userModule.service;


import com.comitfy.healtie.userModule.dto.ContractDTO;
import com.comitfy.healtie.userModule.dto.UserContractDTO;
import com.comitfy.healtie.userModule.dto.requestDTO.UserContractRequestDTO;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

/*    public void addContractToUser(UserContractDTO userContractDTO, Contract contract, User user){
        for (Contract contract1:contract.getUuid()){

        }
        if (contractRequestDTO.isSigned()){
            contract.setUuid(contractRequestDTO.getUuid());
            userRepository.save(user);
        }else {
            return;
        }
    }
    */


    /* public PageDTO<ArticleDTO> getLikedArticleByUser(int page, int size, User user,LanguageEnum languageEnum) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));

        PageDTO<ArticleDTO> pageDTO = getMapper().pageEntityToPageDTO(getRepository().findAllByUser(pageable, user,languageEnum));

        for (ArticleDTO articleDTO : pageDTO.getData()) {
            articleDTO.setLike(isLikedArticleByUser(articleDTO.getUuid(), user.getUuid()));
            articleDTO.setSave(isSavedArticleByUser(articleDTO.getUuid(), user.getUuid()));
            articleDTO.setCommentCount(getRepository().getCountOfComment(articleDTO.getUuid()));
        }
        return getMapper().pageEntityToPageDTO(articleRepository.getLikedArticleOfUser(pageable, user.getUuid()));

    }*/
}
