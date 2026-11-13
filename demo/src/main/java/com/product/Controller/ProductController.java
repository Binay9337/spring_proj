package com.product.Controller;


import com.product.dto.ProductDTO;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProductDto = productService.createProduct(productDTO);

        return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProduct();
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, ProductDTO productDTO){
      return productService.updateProduct(id,productDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(Long id){
        return productService.deleteProduct(id);
    }

}
