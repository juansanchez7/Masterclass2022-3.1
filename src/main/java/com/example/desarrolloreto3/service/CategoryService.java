package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Category;
import com.example.desarrolloreto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category m) {
        if (m.getId() == null) {
            return categoryRepository.save(m);
        } else {
            Optional<Category> e = categoryRepository.getCategory(m.getId());
            if (e.isPresent()) {
                return m;
            }else{
                return categoryRepository.save(m);
            }
        }

    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Category> e = categoryRepository.getCategory(id);
        if (e.isPresent()) {
            categoryRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}