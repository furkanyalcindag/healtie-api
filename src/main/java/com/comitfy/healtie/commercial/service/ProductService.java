package com.comitfy.healtie.commercial.service;

import com.comitfy.healtie.commercial.dto.ProductDTO;
import com.comitfy.healtie.commercial.dto.request.ProductRequestDTO;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.commercial.mapper.ProductMapper;
import com.comitfy.healtie.commercial.repository.OrderRepository;
import com.comitfy.healtie.commercial.repository.ProductCategoryRepository;
import com.comitfy.healtie.commercial.repository.ProductRepository;
import com.comitfy.healtie.commercial.specification.ProductSpecification;
import com.comitfy.healtie.userModule.repository.UserRepository;
import com.comitfy.healtie.util.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductDTO, ProductRequestDTO, Product, ProductRepository, ProductMapper, ProductSpecification> {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductSpecification productSpecification;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductRepository getRepository() {
        return productRepository;
    }

    @Override
    public ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    public ProductSpecification getSpecification() {
        return productSpecification;
    }

/*
    public ProductRequestDTO saveAdvertisementByUser(UUID id, ProductRequestDTO dto) {
        Optional<User> user = userRepository.findByUuid(id);
        if (user.isPresent()) {
            Product product = getMapper().requestDTOToEntity(dto);
            productRepository.save(product);

            return dto;
        } else {
            return null;
        }

    }


    public ProductRequestDTO updateAdvertisement(UUID id, ProductRequestDTO dto, User user) {
        Optional<Product> advertisement = productRepository.findByUuid(id);
        if (advertisement.isPresent()) {
            Product product1 = productMapper.requestDTOToExistEntity(advertisement.get(), dto);
            productRepository.save(product1);
            return dto;
        } else {
            return null;
        }

    }*/

    public ProductRequestDTO saveProductByProductCategory(UUID id, ProductRequestDTO dto) {

        Optional<ProductCategory> productCategory = productCategoryRepository.findByUuid(id);
        if (productCategory.isPresent()) {
            Product product = getMapper().requestDTOToEntity(dto);
            product.setProductCategory(productCategory.get());
            productRepository.save(product);
            return dto;
        } else {
            return null;
        }

    }

}
