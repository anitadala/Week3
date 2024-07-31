package com.week3.springboot.JPA.HibernateandJpa.repositories;

import com.week3.springboot.JPA.HibernateandJpa.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


    List<ProductEntity> findByTitle(String title);
}
