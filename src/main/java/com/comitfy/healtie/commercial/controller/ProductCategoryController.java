package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.ProductCategoryDTO;
import com.comitfy.healtie.commercial.dto.request.ProductCategoryRequestDTO;
import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.commercial.mapper.ProductCategoryMapper;
import com.comitfy.healtie.commercial.repository.ProductCategoryRepository;
import com.comitfy.healtie.commercial.service.ProductCategoryService;
import com.comitfy.healtie.commercial.specification.ProductCategorySpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product-category")
public class ProductCategoryController extends BaseCrudController<ProductCategoryDTO, ProductCategoryRequestDTO, ProductCategory, ProductCategoryRepository, ProductCategoryMapper, ProductCategorySpecification, ProductCategoryService> {

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    protected ProductCategoryService getService() {
        return productCategoryService;
    }

    @Override
    protected ProductCategoryMapper getMapper() {
        return productCategoryMapper;
    }
}
