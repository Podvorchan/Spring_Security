package com.example.spring_security.controller;

import com.example.spring_security.model.Product;
import com.example.spring_security.dto.ProductDto;
import com.example.spring_security.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Podvorchan Ruslan 23.02.2023
 */
@Controller
@RequestMapping("product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public String getAllProduct(Model model) {
    log.info("List of products");
    model.addAttribute(" ", "All Products");
    model.addAttribute("listProducts", productService.getAllProduct());
    return "product";
  }

  @GetMapping("add")
  public String addProducts(Model model) {
    log.info("Add products page");
    model.addAttribute("productForm", new Product());
    return "add";
  }

  @GetMapping("{id}/delete")
  public String deleteProduct(Model model, @PathVariable Integer id) {
    log.info("Delete Product");
    productService.deleteById(id);
    model.addAttribute("listProducts", productService.getAllProduct());
    return "redirect:/product";
  }


  @PostMapping("add")
  public String add(Model model, @ModelAttribute("productForm") Product product) {
    log.info("Save product details");

    List<String> validationErrors = new ArrayList<>();
    if (product.getName() == null || product.getName().isEmpty()) {
      validationErrors.add("Name is required");
    }

    if (product.getCost() == null) {
      validationErrors.add("Cost ");
    }

    if (!validationErrors.isEmpty()) {
      model.addAttribute("error:", validationErrors);

      return "add";
    }

    productService.addProduct(new ProductDto(null, product.getName(), product.getCost()));
    return "redirect:/product";

  }

  @GetMapping("{id}")
  public String getByIdProduct(Model model, @PathVariable int id) {
    if (id < 0) {
      throw new IllegalArgumentException("ID less than zero");
    }
    model.addAttribute("product", productService.getByIdProduct(id));
    return "details";
  }


}
