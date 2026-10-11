package com.quickCommerce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String itemId;

    @Column(nullable = false,length = 150)
    private String itemName;

    @Column(columnDefinition = "TEXT")
    private String itemDescription;

    @Column(nullable = false)
    private double itemPrice;

    @Column(nullable = false)
    private int availableQuantity;

    @Column(nullable = false)
    private boolean active =true;

    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "category_id" , nullable = false)
    private Category category;

}
