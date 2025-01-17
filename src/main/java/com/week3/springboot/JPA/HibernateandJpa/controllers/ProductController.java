package com.week3.springboot.JPA.HibernateandJpa.controllers;

import com.week3.springboot.JPA.HibernateandJpa.entities.ProductEntity;
import com.week3.springboot.JPA.HibernateandJpa.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productRepository.findByTitleByOrderByPrice("Pepsi");
    }

}
