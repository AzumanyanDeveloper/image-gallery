package com.imagegallery.imagegallery.service;

import com.imagegallery.imagegallery.model.Category;
import com.imagegallery.imagegallery.dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryDao categoryDao;

    public List<Category> findAll() {
       return categoryDao.findAllByNameNotNull();
    }
}
