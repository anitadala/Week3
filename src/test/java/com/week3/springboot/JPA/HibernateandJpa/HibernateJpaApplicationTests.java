package com.week3.springboot.JPA.HibernateandJpa;

import com.week3.springboot.JPA.HibernateandJpa.entities.ProductEntity;
import com.week3.springboot.JPA.HibernateandJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
				.sku("nestle773")
				.title("Nestle Product")
				.price(BigDecimal.valueOf(120.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}


	@Test
	void getRepository() {
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024, 1, 1, 0, 0, 0)
//		);
		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(12,BigDecimal.valueOf(127.45));
		System.out.println(entities);
	}

	@Test
	void checkRepository() {
		Optional<ProductEntity> entity = productRepository.
				findByTitleAndPrice("Pepsi", BigDecimal.valueOf(12.4));
		entity.ifPresent(System.out::println);
	}
}
