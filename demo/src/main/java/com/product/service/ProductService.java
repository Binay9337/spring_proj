package com.product.service;

import com.product.Exception.CategoryNotFound;
import com.product.dto.ProductDTO;
import com.product.entity.Category;
import com.product.entity.Product;
import com.product.mapper.ProductMapper;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new CategoryNotFound("no category found on id: "+ productDTO.getCategoryId()));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // get all products
    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("no such product is available with " + id));
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(("no product available with this " + id)));

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException(("no category available with this " + productDTO.getCategoryId())));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public String deleteProduct(Long id){
       Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not available"));
       productRepository.delete(product);
       return "product got deleted";
    }
}


