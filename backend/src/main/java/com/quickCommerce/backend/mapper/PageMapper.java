package com.quickCommerce.backend.mapper;

import com.quickCommerce.backend.dto.response.PageResponse;
import org.springframework.data.domain.Page;

public class PageMapper {
    private PageMapper() {
    }

    public static <T> PageResponse<T> toResponse(Page<T> page) {
        PageResponse<T> response = new PageResponse<T>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages(), page.isFirst(), page.isLast());
        return response;
    }

}
