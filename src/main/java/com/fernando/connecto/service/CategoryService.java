package com.fernando.connecto.service;

import com.fernando.connecto.exceptions.ObjectAlreadyPresentException;
import com.fernando.connecto.exceptions.ObjectNotFoundException;
import com.fernando.connecto.model.Category;
import com.fernando.connecto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private void checkExistence(String name){
        if(findByName(name).isPresent()){
            throw new ObjectAlreadyPresentException("Category '"+name+"' already exists");
        }
    }

    private Optional<Category> findByName(String name){
        return categoryRepository.findByName(name);
    }

    public Category findById(long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.isPresent() ? obj.get() : obj.orElseThrow(() -> new ObjectNotFoundException("Category id="+id+" not found"));
    }

    public List<Category> findAll (){
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }

    public Category save (Category category){
        category.setName(category.getName().toLowerCase());
        checkExistence(category.getName());
        return categoryRepository.save(category);
    }

    public Category update(long id, Category newObj){
        newObj.setName(newObj.getName().toLowerCase());
        Category oldObj = findById(id);
        if(!oldObj.getName().toLowerCase().equals(newObj.getName().toLowerCase())){
            checkExistence(newObj.getName());
        }
        newObj.setId(id);
        return categoryRepository.save(newObj);
    }

    public void delete(long id){
        findById(id);
        categoryRepository.deleteById(id);
    }

}
