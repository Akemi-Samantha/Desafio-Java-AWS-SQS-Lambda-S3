package com.estudo.desafiojavaaws.controllers;

import com.estudo.desafiojavaaws.domain.category.CatagoryDto;
import com.estudo.desafiojavaaws.domain.category.Category;
import com.estudo.desafiojavaaws.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CatagoryDto catagoryDto){
       Category newCategory = this.categoryService.insert(catagoryDto);
         return ResponseEntity.ok(newCategory);

    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CatagoryDto catagoryDto){
        Category updatedCategory = this.categoryService.update(id, catagoryDto);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
