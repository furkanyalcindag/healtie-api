package com.comitfy.healtie.commercial.mapper;

import com.comitfy.healtie.app.model.enums.LanguageEnum;
import com.comitfy.healtie.commercial.dto.ProductDTO;
import com.comitfy.healtie.commercial.dto.request.ProductRequestDTO;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.util.PageDTO;
import com.comitfy.healtie.util.common.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements BaseMapper<ProductDTO, ProductRequestDTO, Product> {

    @Override
    public ProductDTO entityToDTO(Product entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setLocation(entity.getLocation());
        productDTO.setHeight(entity.getHeight());
        productDTO.setWidth(entity.getWidth());
        productDTO.setPrice(entity.getPrice());
        productDTO.setUuid(entity.getUuid());

        productDTO.setTotalPrice((entity.getPrice()) + ((entity.getPrice() * (entity.getTaxRatio()) / 100)));

        return productDTO;
    }

    @Override
    public Product dtoToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setLocation(dto.getLocation());
        product.setHeight(dto.getHeight());
        product.setWidth(dto.getWidth());
        product.setPrice(dto.getPrice());

        return product;

    }

    @Override
    public Product requestDTOToEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setLocation(dto.getLocation());
        product.setHeight(dto.getHeight());
        product.setWidth(dto.getWidth());
        product.setPrice(dto.getPrice());
        product.setTaxRatio(dto.getTaxRatio());
      product.setTotalPrice(dto.getPrice()+(dto.getPrice()+(dto.getTaxRatio())/100));

        return product;
    }

    @Override
    public Product requestDTOToExistEntity(Product product, ProductRequestDTO dto) {

        product.setLocation(dto.getLocation());
        product.setHeight(dto.getHeight());
        product.setWidth(dto.getWidth());
        product.setPrice(dto.getPrice());
        product.setTaxRatio(dto.getTaxRatio());

        return product;
    }

    @Override
    public List<Product> dtoListToEntityList(List<ProductDTO> productDTOS) {
        List<Product> productList = new ArrayList<Product>();
        for (ProductDTO productDTO : productDTOS) {
            Product product = dtoToEntity(productDTO);
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<Product> products) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = entityToDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public PageDTO<ProductDTO> pageEntityToPageDTO(Page<Product> pageEntity) {
        PageDTO<ProductDTO> pageDTO = new PageDTO<ProductDTO>();
        List<Product> entityList = pageEntity.toList();
        List<ProductDTO> productDTOList = entityListToDTOList(entityList);
        pageDTO.setStart(pageEntity, productDTOList);

        return pageDTO;
    }
}
