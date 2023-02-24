package com.example.spring_security.repository;

import com.example.spring_security.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
