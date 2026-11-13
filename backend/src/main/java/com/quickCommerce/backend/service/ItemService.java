package com.quickCommerce.backend.service;


import com.quickCommerce.backend.dto.request.ItemRequest;
import com.quickCommerce.backend.dto.response.ItemResponse;
import com.quickCommerce.backend.dto.response.PageResponse;
import com.quickCommerce.backend.entity.Category;
import com.quickCommerce.backend.entity.Item;
import com.quickCommerce.backend.exception.ResourceNotFound;
import com.quickCommerce.backend.mapper.ItemMapper;
import com.quickCommerce.backend.mapper.PageMapper;
import com.quickCommerce.backend.repository.CategoryRepository;
import com.quickCommerce.backend.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public PageResponse<ItemResponse> getItems(String search, String categoryId, Double minPrice, Double maxPrice,
                                               Boolean active, int pageSize, int pageNumber, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                sortDir.equalsIgnoreCase("asc")
                        ? Sort.by(Sort.Direction.ASC, sortBy)
                        : Sort.by(Sort.Direction.DESC, sortBy));

        Page<Item> pageItem = itemRepository.searchItems(search, categoryId, minPrice, maxPrice, active, pageable);
        Page<ItemResponse> pageItemResponse = pageItem.map(ItemMapper::toResponse);
        return PageMapper.toResponse(pageItemResponse);
    }

    public ItemResponse getItemById(String itemId) {
        Item itemById = findIdOrThrow(itemId);
        return ItemMapper.toResponse(itemById);
    }

    public void deleteItem(String itemId) {

        getItemById(itemId);
        itemRepository.deleteById(itemId);
    }

    private Item findIdOrThrow(String itemId) {
        Item itemById = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFound("item not found "));
        return itemById;

    }

    public ItemResponse createitem(ItemRequest itemRequest) {

        Category categoryById = findByCategoryIdOrThrow(itemRequest.categoryId());
        Item item = ItemMapper.toEntity(itemRequest,categoryById);

        Item savedItem = itemRepository.save(item);
        return ItemMapper.toResponse(savedItem);
    }

    private Category findByCategoryIdOrThrow(String categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFound("category not found"));
    }


    public ItemResponse updateItem(String itemId,  ItemRequest itemRequest) {
        findByCategoryIdOrThrow(itemId);
        Category categoryById = findByCategoryIdOrThrow(itemRequest.categoryId());
        Item existingItem = ItemMapper.toEntity(itemRequest,categoryById);
        existingItem.setItemId(itemId);

        Item updatedItem = itemRepository.save(existingItem);
        return  ItemMapper.toResponse(updatedItem);
    }
}