package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.commercial.dto.ProductCategoryDTO;
import com.comitfy.healtie.commercial.dto.request.ProductCategoryRequestDTO;
import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCategoryMapper implements BaseMapper<ProductCategoryDTO, ProductCategoryRequestDTO, ProductCategory> {
    @Override
    public ProductCategoryDTO entityToDTO(ProductCategory entity) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setName(entity.getName());
        productCategoryDTO.setUuid(entity.getUuid());
        return productCategoryDTO;
    }

    @Override
    public ProductCategory dtoToEntity(ProductCategoryDTO dto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.getName());
        return productCategory;
    }

    @Override
    public ProductCategory requestDTOToEntity(ProductCategoryRequestDTO dto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.getName());
        return productCategory;
    }

    @Override
    public ProductCategory requestDTOToExistEntity(ProductCategory entity, ProductCategoryRequestDTO dto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(dto.getName());
        return productCategory;
    }

    @Override
    public List<ProductCategory> dtoListToEntityList(List<ProductCategoryDTO> productCategoryDTOS) {
        List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
        for (ProductCategoryDTO productCategoryDTO : productCategoryDTOS) {
            ProductCategory productCategory = dtoToEntity(productCategoryDTO);
            productCategories.add(productCategory);
        }
        return productCategories;
    }

    @Override
    public List<ProductCategoryDTO> entityListToDTOList(List<ProductCategory> productCategories) {
        List<ProductCategoryDTO> productCategoryDTOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductCategoryDTO productCategoryDTO = entityToDTO(productCategory);
            productCategoryDTOList.add(productCategoryDTO);
        }
        return productCategoryDTOList;
    }

    @Override
    public PageDTO<ProductCategoryDTO> pageEntityToPageDTO(Page<ProductCategory> pageEntity) {
        PageDTO<ProductCategoryDTO> pageDTO = new PageDTO<ProductCategoryDTO>();
        List<ProductCategory> entityList = pageEntity.toList();
        List<ProductCategoryDTO> productCategoryDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, productCategoryDTOList);

        return pageDTO;
    }
}

