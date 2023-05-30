package com.example.important_shop.service;

import com.example.important_shop.entity.Category;
import com.example.important_shop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findCategories();
    Optional<Category> findById(int id);

    void addCategory(Category category) throws IOException;

    void deleteById(int id);
}
