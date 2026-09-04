package ru.edu.games.onlinestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.entity.CategoryEntity;
import ru.edu.games.onlinestore.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List <CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }

    public CategoryEntity createCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }

}
