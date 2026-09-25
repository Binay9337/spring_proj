package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.hibernate.service.internal.ProvidedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MethodsOfJpaApplication {

	private final OrdersService ordersService;
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;

	

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Product product = Product.builder().producName("iPhone").producBrand("Apple").productPrice(100000.25)
					.build();

			// // save()
			// Product saveProduct = productRepository.save(product);
			// System.out.println("saved product is: " + saveProduct);

			// // saveAll()
			// productRepository.saveAll(getAllProducts());

			// // count()
			// Long totalProducts = productRepository.count();
			// System.out.println("total prodcut is: " + totalProducts);

			// // ExistById
			// // Product iPhone = productRepository.findById(1).orElseThrow();
			// boolean isIdExist = productRepository.existsById(1);

			// System.out.println("is id Exist " + isIdExist);

			// Product existingProduct = productRepository.findById(1).orElseThrow();
			// boolean isIphoneExist =
			// productRepository.exists(Example.of(existingProduct));
			// System.out.println("is iphone exists : " + isIphoneExist);

			// // delete()
			// Product item = productRepository.findById(5).orElseThrow();
			// productRepository.delete(item);

			// deleteById()
			// productRepository.deleteById(3);

			// findAll() -->> this is overloaded
			// List<Product> products = productRepository.findAll();
			// products.forEach((p) -> System.out.println(p));

			// List<Product> products = productRepository.findAll(Sort.by("productPrice"));
			// // it is by default ascending so it gives ascending order
			// products.forEach(System.out::println);

			// List<Product> productPriceSort =
			// productRepository.findAll(Sort.by(Direction.DESC, "productPrice"));
			// products.forEach(System.out::println);

			// Product foundProduct = productRepository.findById(10).orElseThrow();
			// foundProduct.setProducName("door");
			// productRepository.save(foundProduct);

			// ======Pagination
			// ================================================================================

			// page number -> 0 based indexing
			// page size -> number of data inside the page
			// Page<Product> products = productRepository.findAll(PageRequest.of(0, 5));
			// System.out.println("page info is : " + products);
			// products.forEach(System.out::println);

			// here skip one page
			// Page<Product> productSkipFirstPage =
			// productRepository.findAll(PageRequest.of(1, 5));
			// System.out.println("page info is : " + productSkipFirstPage);
			// productSkipFirstPage.forEach(System.out::println);

			// // here if u want to by sorting
			// Page<Product> sortingPage = productRepository.findAll(PageRequest.of(1, 5,
			// Direction.DESC, "productPrice"));
			// System.out.println("page info is : " + productSkipFirstPage);
			// productSkipFirstPage.forEach(System.out::println);
			// ===================================================================================================

			// Product monitor =
			// productRepository.findByProducName("Monitor").orElseThrow();
			// System.out.println("product is: " + monitor);

			// Product chair = productRepository.findByProducName("chair").orElseThrow();
			// System.out.println("product is: " + chair);

			// productRepository.findAllByProductPriceBetween(10000,
			// 50000).forEach(System.out::println);

			// productRepository.findAllByProductPriceGreaterThanEqual(20000,
			// Sort.by(Direction.ASC, "productPrice"))
			// .forEach(System.out::println);

			productRepository.findByProducNameAndProducBrand("product 1", "brand 1")
					.ifPresent(p -> System.out.println(p));

			// ============JPQL=================

			// productRepository.getProductNamed("product 2", "brand 2").ifPresent(p -> System.out.println(p));

			// productRepository.getProductRawSql("product 4", "brand 4").ifPresent(p -> System.out.println(p));

			// int affectedRow = productRepository.updatePrice(2, 40000);
			// System.out.println("no of affeccted row: " + affectedRow);
			// =========================================================================

			ordersService.placeOrder(1, 11);

		};
	}

	// public List<Product> getAllProducts() {
	// return IntStream.range(1, 10)
	// .mapToObj(i -> Product.builder().producName("product " +
	// i).producBrand("brand " + i)
	// .productPrice(1000 * i).build())
	// .toList();
	// }

}

/*
 * IntStream give value as per start and end value
 */

/*
 * if want to do ncustom things is not in the jpa
 * -- Custom query method
 * -- JPQL
 * -- plain sql / raw sql
 * 
 */