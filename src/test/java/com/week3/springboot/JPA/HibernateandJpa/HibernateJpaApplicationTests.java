package com.week3.springboot.JPA.HibernateandJpa;

import com.week3.springboot.JPA.HibernateandJpa.entities.ProductEntity;
import com.week3.springboot.JPA.HibernateandJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class HibernateJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle123")
				.title("Nestle Product")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}


	@Test
	void getRepository(){
		List<ProductEntity> entities = productRepository.findByTitle("Pepsi");
		System.out.println(entities);
	}


}
