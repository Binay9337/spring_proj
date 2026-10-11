package com.quickCommerce.backend.mapper;


import com.quickCommerce.backend.dto.request.ItemRequest;
import com.quickCommerce.backend.dto.response.ItemResponse;
import com.quickCommerce.backend.entity.Category;
import com.quickCommerce.backend.entity.Item;

public class ItemMapper {
    private ItemMapper() {}

    public static ItemResponse toResponse(Item item) {
        ItemResponse response = new ItemResponse(
                item.getItemId(),
                item.getItemName(),
                item.getItemDescription(),
                item.getItemPrice(),
                item.getImage(),
                item.getAvailableQuantity(),
                item.isActive(),
                item.getCategory().getCategoryId(),
                item.getCategory().getCategoryName()
        );

        return response;
    }
    public static Item toEntity(ItemRequest itemRequest, Category category){
        return Item.builder().itemName(itemRequest.itemName()).itemDescription(itemRequest.itemDescription()).itemPrice(itemRequest.itemPrice()).category(category).active(itemRequest.active() == null ? true : itemRequest.active()).build();
    }
}