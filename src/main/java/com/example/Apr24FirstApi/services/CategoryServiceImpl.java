package com.example.Apr24FirstApi.services;

import com.example.Apr24FirstApi.models.Category;
import com.example.Apr24FirstApi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        /*
        If id is null for the object being saved: then insert query will be fired
        Else update query will be fired
         */
        return categoryRepository.save(category);
    }
}
