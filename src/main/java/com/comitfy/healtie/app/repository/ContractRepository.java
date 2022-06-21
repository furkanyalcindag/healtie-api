package com.comitfy.healtie.app.repository;

import com.comitfy.healtie.app.entity.Contract;
import com.comitfy.healtie.app.entity.Language;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends BaseRepository<Contract> {

    Page<Contract> findAllByActivatedAndLanguageEnum(Pageable pageable, boolean isActive, LanguageEnum languageEnum);

   // Page<Contract> findAllByActivatedAndLanguage(Pageable pageable, boolean isActive, String language);

}
