package com.example.methods_of_jpa;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Transactional 
    public void placeOrder(int productId, int quantity) {
        var product = productRepository.findById(productId).orElseThrow();
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        if (quantity == 11) {
            throw new RuntimeException("exceptioon occured");
        }

        var order = Orders.builder()
                .quantity(quantity)
                .totalPrice(product.getProductPrice() * quantity).build();

        orderRepository.save(order);

    }
}
