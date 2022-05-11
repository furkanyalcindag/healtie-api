package com.comitfy.healtie.util.common;

import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.model.enums.LanguageEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseWithMultiLanguageRepository<T> extends PagingAndSortingRepository<T,Long> {

    Optional<T> findByUuid(UUID uuid);
    Page<T> findAllByLanguageEnum(Pageable pageable,LanguageEnum languageEnum);


}
