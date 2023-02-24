package com.example.spring_security.service;

import static java.util.stream.Collectors.toList;

import com.example.spring_security.dto.ProductDto;
import com.example.spring_security.model.Product;
import com.example.spring_security.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;


  public void addProduct(ProductDto productDto) {
    Product product = objectMapper.convertValue(productDto, Product.class);
    productRepository.save(product);
    productDto.setId(product.getId());
  }


  public ProductDto deleteById(Integer id) {
    log.info("Remove product by id={}", id);
    ProductDto productDto = getByIdProduct(id);
    productRepository.delete(objectMapper.convertValue(productDto, Product.class));
    log.info("Product: {} removed", productDto);
    return productDto;
  }


  public ProductDto getByIdProduct(Integer id) {
    log.info("Find product by id={}", id);
    Product product = productRepository
        .findById(id)
        .orElseThrow(() -> {
          log.error("Product with id={} wasn't found", id);
          return new EntityNotFoundException("Product with id=" + id + " wasn't found");
        });
    ProductDto productDto = objectMapper.convertValue(product, ProductDto.class);
    log.info("Product: {} ", productDto);
    return productDto;
  }


  public List<ProductDto> getAllProduct() {
    log.info("Find all products");
    List<Product> products = (List<Product>) productRepository.findAll();
    return products.stream()
        .map(p -> objectMapper.convertValue(p, ProductDto.class))
        .collect(toList());
  }

}
