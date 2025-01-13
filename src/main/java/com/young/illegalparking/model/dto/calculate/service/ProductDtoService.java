package com.young.illegalparking.model.dto.calculate.service;

import com.young.illegalparking.model.dto.calculate.domain.ProductDto;
import com.young.illegalparking.model.entity.product.domain.Product;

import java.util.List;

/**
 * Date : 2022-09-27
 * Author : young
 * Editor :
 * Project : illegalParking
 * Description :
 */
public interface ProductDtoService {

    ProductDto get(Product product);

    List<ProductDto> gets(List<Product> products);

}
