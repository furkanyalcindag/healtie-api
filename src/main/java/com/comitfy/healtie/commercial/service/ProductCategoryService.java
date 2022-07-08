package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.ProductCategoryDTO;
import com.comitfy.healtie.commercial.dto.request.ProductCategoryRequestDTO;
import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.commercial.mapper.ProductCategoryMapper;
import com.comitfy.healtie.commercial.repository.ProductCategoryRepository;
import com.comitfy.healtie.commercial.specification.ProductCategorySpecification;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService extends BaseService<ProductCategoryDTO, ProductCategoryRequestDTO, ProductCategory, ProductCategoryRepository, ProductCategoryMapper, ProductCategorySpecification> {

    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Autowired
    ProductCategorySpecification productCategorySpecification;

    @Override
    public ProductCategoryRepository getRepository() {
        return productCategoryRepository;
    }

    @Override
    public ProductCategoryMapper getMapper() {
        return productCategoryMapper;
    }

    @Override
    public ProductCategorySpecification getSpecification() {
        return productCategorySpecification;
    }
}
