package com.comitfy.healtie.userModule.repository;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.userModule.entity.Contract;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends BaseRepository<Contract> {

    Page<Contract> findAllByActivatedAndLanguageEnum(Pageable pageable, boolean isActive, LanguageEnum languageEnum);

    Optional<Contract> findAllByRequired(boolean isRequired);

   // Page<Contract> findAllByActivatedAndLanguage(Pageable pageable, boolean isActive, String language);

}
