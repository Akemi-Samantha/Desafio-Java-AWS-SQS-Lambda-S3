package com.estudo.desafiojavaaws.services;

import com.estudo.desafiojavaaws.domain.category.CatagoryDto;
import com.estudo.desafiojavaaws.domain.category.Category;
import com.estudo.desafiojavaaws.domain.category.exceptions.CategoryNotFoundException;
import com.estudo.desafiojavaaws.repository.CategoryRepository;
import com.estudo.desafiojavaaws.services.aws.AwsSnsService;
import com.estudo.desafiojavaaws.services.aws.MessageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final AwsSnsService awsSnsService;

    public CategoryService(CategoryRepository categoryRepository, AwsSnsService awsSnsService) {
        this.categoryRepository = categoryRepository;
        this.awsSnsService = awsSnsService;
    }

    public Category insert(CatagoryDto catagoryDto){
        Category newCategory = new Category(catagoryDto);
        this.categoryRepository.save(newCategory);
        this.awsSnsService.publish(new MessageDto(newCategory.toString()));
        return newCategory;

    }

    public Category update(String id, CatagoryDto catagoryDto) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        if(!catagoryDto.title().isEmpty()){
            category.setTitle(catagoryDto.title());
        }
        if(!catagoryDto.description().isEmpty()){
            category.setDescription(catagoryDto.description());
        }
        this.categoryRepository.save(category);
        this.awsSnsService.publish(new MessageDto(category.toString()));
        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        this.categoryRepository.delete(category);
    }


    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }


    public Optional<Category> getById(String id) {
        return this.categoryRepository.findById(id);
    }
}
