package com.example.desarrolloreto3.repository;

import com.example.desarrolloreto3.entities.Category;
import com.example.desarrolloreto3.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryRepository;

    public List<Category>getAll(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Category save(Category m){
        return categoryRepository.save(m);
    }

    public void delete(Category m){
        categoryRepository.delete(m);
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.findById(id);
    }


}
