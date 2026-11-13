package com.quickCommerce.backend.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.quickCommerce.backend.constant.AppConstant;
import com.quickCommerce.backend.dto.response.CategoryResponse;
import com.quickCommerce.backend.dto.response.ItemResponse;
import com.quickCommerce.backend.dto.response.UserResponse;
import com.quickCommerce.backend.entity.Category;
import com.quickCommerce.backend.entity.Item;
import com.quickCommerce.backend.entity.UserEntity;
import com.quickCommerce.backend.exception.ResourceNotFound;
import com.quickCommerce.backend.mapper.CategoryMapper;
import com.quickCommerce.backend.mapper.ItemMapper;
import com.quickCommerce.backend.mapper.UserMapper;
import com.quickCommerce.backend.repository.CategoryRepository;
import com.quickCommerce.backend.repository.ItemRepository;
import com.quickCommerce.backend.repository.UserRepository;
import com.quickCommerce.backend.util.FileStorageUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

// ── Category image ────────────────────────────────────────────────────────

    public CategoryResponse uploadCategoryImage(String categoryId, MultipartFile image) {
        Category category = findCategoryOrThrow(categoryId);

        // Replace old image if exists
        if (category.getCategoryImage() != null) {
            FileStorageUtil.deleteFile(category.getCategoryImage(), AppConstant.UPLOAD_DIR_CATEGORIES);
        }

        String newFileName = FileStorageUtil.saveImage(image, AppConstant.UPLOAD_DIR_CATEGORIES);
        category.setCategoryImage(newFileName);
        categoryRepository.save(category);

        return CategoryMapper.toResponse(category);
    }

    public byte[] getCategoryImage(String categoryId) throws IOException {
        Category category = findCategoryOrThrow(categoryId);

        String imageName = category.getCategoryImage();
        if (imageName == null || imageName.isBlank()) {
            throw new ResourceNotFound("No image found for this category");
        }

        return readFileBytes(AppConstant.UPLOAD_DIR_CATEGORIES, imageName);
    }

// ── Item image ────────────────────────────────────────────────────────────

    public ItemResponse uploadItemImage(String itemId, MultipartFile image) {
        Item item = findItemOrThrow(itemId);

        if (item.getImage() != null) {
            FileStorageUtil.deleteFile(item.getImage(), AppConstant.UPLOAD_DIR_ITEMS);
        }

        String newFileName = FileStorageUtil.saveImage(image, AppConstant.UPLOAD_DIR_ITEMS);
        item.setImage(newFileName);
        itemRepository.save(item);

        return ItemMapper.toResponse(item);
    }

    public byte[] getItemImage(String itemId) throws IOException {
        Item item = findItemOrThrow(itemId);

        String imageName = item.getImage();
        if (imageName == null || imageName.isBlank()) {
            throw new ResourceNotFound("No image found for this item");
        }

        return readFileBytes(AppConstant.UPLOAD_DIR_ITEMS, imageName);
    }

// ── Profile image ─────────────────────────────────────────────────────────

    public UserResponse uploadProfileImage(String userId, MultipartFile image) {
        UserEntity user = findUserOrThrow(userId);

        if (user.getProfileImage() != null) {
            FileStorageUtil.deleteFile(user.getProfileImage(), AppConstant.UPLOAD_DIR_PROFILE_IMAGE);
        }

        String newFileName = FileStorageUtil.saveImage(image, AppConstant.UPLOAD_DIR_PROFILE_IMAGE);
        user.setProfileImage(newFileName);
        userRepository.save(user);

        return UserMapper.toResponse(user);
    }

    public byte[] getProfileImage(String userId) throws IOException {
        UserEntity user = findUserOrThrow(userId);

        String imageName = user.getProfileImage();
        if (imageName == null || imageName.isBlank()) {
            throw new ResourceNotFound("No profile image found for this user");
        }

        return readFileBytes(AppConstant.UPLOAD_DIR_PROFILE_IMAGE, imageName);
    }

    public UserResponse removeProfileImage(String userId) {
        UserEntity user = findUserOrThrow(userId);

        if (user.getProfileImage() == null) {
            throw new ResourceNotFound("No profile image to remove");
        }

        FileStorageUtil.deleteFile(user.getProfileImage(), AppConstant.UPLOAD_DIR_PROFILE_IMAGE);
        user.setProfileImage(null);
        userRepository.save(user);

        return UserMapper.toResponse(user);
    }

// ── Shared helpers ────────────────────────────────────────────────────────

    /**
     * Reads a file and returns its raw bytes.
     */
    private byte[] readFileBytes(String directory, String fileName) throws IOException {
        File file = new File(directory + File.separator + fileName);
        if (!file.exists()) {
            throw new ResourceNotFound("Image file not found on server: " + fileName);
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }

// ── Image name resolvers (used by controller for Content-Type) ───────────

    public String getCategoryImageName(String categoryId) {
        return findCategoryOrThrow(categoryId).getCategoryImage();
    }

    public String getItemImageName(String itemId) {
        return findItemOrThrow(itemId).getImage();
    }

    public String getProfileImageName(String userId) {
        return findUserOrThrow(userId).getProfileImage();
    }

    private Category findCategoryOrThrow(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category not found"));
    }

    private Item findItemOrThrow(String id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Item not found"));
    }

    private UserEntity findUserOrThrow(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found"));
    }
}