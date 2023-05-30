package com.example.important_shop.service.impl;

import com.example.important_shop.entity.Category;
import com.example.important_shop.repository.CategoryRepository;
import com.example.important_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void addCategory(Category category)  {
        categoryRepository.save(category);

    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}


