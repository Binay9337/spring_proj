package com.quickCommerce.backend.controller;

import com.quickCommerce.backend.constant.AppConstant;
import com.quickCommerce.backend.dto.request.ItemRequest;
import com.quickCommerce.backend.dto.response.ItemResponse;
import com.quickCommerce.backend.dto.response.PageResponse;
import com.quickCommerce.backend.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public PageResponse<ItemResponse> getItems(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String categoryId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false, defaultValue = "true") Boolean active,
            @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int pageSize,
            @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int pageNumber,
            @RequestParam(defaultValue = "itemName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        return itemService.getItems(search, categoryId, minPrice, maxPrice, active, pageSize, pageNumber, sortBy, sortDir);
    }
    @GetMapping("/{itemId}")
    @ResponseStatus(HttpStatus.CREATED)
     public ItemResponse getItemById(@PathVariable String itemId){
        return itemService.getItemById(itemId);
     }
    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String itemId){
         itemService.deleteItem(itemId);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ItemResponse createItem(@RequestBody @Valid ItemRequest itemRequest){
        return  itemService.createitem(itemRequest);
    }
    @PutMapping("/{itemId}")
    @ResponseStatus(HttpStatus.CREATED)
    public  ItemResponse updateItem(@PathVariable String itemId,
                                    @RequestBody @Valid ItemRequest itemRequest){
        return  itemService.updateItem(itemId,itemRequest);
    }

}