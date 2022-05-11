package com.comitfy.healtie.app.service;

import com.comitfy.healtie.app.dto.CategoryDTO;
import com.comitfy.healtie.app.dto.requestDTO.CategoryRequestDTO;
import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.mapper.CategoryMapper;
import com.comitfy.healtie.app.repository.CategoryRepository;
import com.comitfy.healtie.util.common.BaseService;
import com.comitfy.healtie.util.common.BaseWithMultiLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseWithMultiLanguageService<CategoryDTO, CategoryRequestDTO, Category, CategoryRepository, CategoryMapper> {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryRepository getRepository() {
        return categoryRepository;
    }

    @Override
    public CategoryMapper getMapper() {
        return categoryMapper;
    }
}
