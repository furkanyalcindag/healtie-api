package com.comitfy.healtie.app.controller;

import com.comitfy.healtie.app.dto.CategoryDTO;
import com.comitfy.healtie.app.dto.requestDTO.CategoryRequestDTO;
import com.comitfy.healtie.app.entity.Category;
import com.comitfy.healtie.app.mapper.CategoryMapper;
import com.comitfy.healtie.app.repository.CategoryRepository;
import com.comitfy.healtie.app.service.CategoryService;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseCrudController<CategoryDTO, CategoryRequestDTO, Category, CategoryRepository, CategoryMapper, CategoryService> {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    protected CategoryService getService() {
        return categoryService;
    }

    @Override
    protected CategoryMapper getMapper() {
        return categoryMapper;
    }
}
