package com.comitfy.healtie.commercial.controller;

import com.comitfy.healtie.commercial.dto.ProductDTO;
import com.comitfy.healtie.commercial.dto.request.ProductRequestDTO;
import com.comitfy.healtie.commercial.entity.Product;
import com.comitfy.healtie.commercial.entity.ProductCategory;
import com.comitfy.healtie.commercial.mapper.ProductMapper;
import com.comitfy.healtie.commercial.repository.ProductRepository;
import com.comitfy.healtie.commercial.service.ProductCategoryService;
import com.comitfy.healtie.commercial.service.ProductService;
import com.comitfy.healtie.commercial.specification.ProductSpecification;
import com.comitfy.healtie.util.common.BaseCrudController;
import com.comitfy.healtie.util.common.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController extends BaseCrudController<ProductDTO, ProductRequestDTO, Product, ProductRepository, ProductMapper, ProductSpecification, ProductService> {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    HelperService helperService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Override
    protected ProductService getService() {
        return productService;
    }

    @Override
    protected ProductMapper getMapper() {
        return productMapper;
    }

/*    @PostMapping("/user-api")
    public ResponseEntity<ProductRequestDTO> saveByUserID(@RequestHeader(value = "accept-language", required = true) String acceptLanguage,
                                                          @RequestBody ProductRequestDTO productRequestDTO) {
        User user = helperService.getUserFromSession();
        if (user != null) {
            return new ResponseEntity<>(productService.saveAdvertisementByUser(user.getUuid(), productRequestDTO), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }





    @PutMapping("/user-api/{advertisementId}")
    public ResponseEntity<String> updateAdvertisement(@PathVariable UUID advertisementId, @RequestBody ProductRequestDTO dto) {
        User user = helperService.getUserFromSession();
        ProductDTO productDTO = productService.findByUUID(advertisementId);

        if (productDTO == null || user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);

        } else {
            productService.updateAdvertisement(advertisementId, dto, user);
            return new ResponseEntity<>("The object was updated.", HttpStatus.OK);

        }
    }*/

    @PostMapping("/{productCategoryId}")
    public ResponseEntity<ProductRequestDTO> saveProductByProductCategory(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable UUID productCategoryId) {
        ProductCategory productCategory = productCategoryService.findEntityByUUID(productCategoryId);
        if (productCategory != null) {
            return new ResponseEntity<>(productService.saveProductByProductCategory(productCategoryId, productRequestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
