package com.estudo.desafiojavaaws.services;

import com.estudo.desafiojavaaws.domain.category.Category;
import com.estudo.desafiojavaaws.domain.category.exceptions.CategoryNotFoundException;
import com.estudo.desafiojavaaws.domain.product.Product;
import com.estudo.desafiojavaaws.domain.product.ProductDto;
import com.estudo.desafiojavaaws.domain.product.exceptions.ProductNotFoundException;
import com.estudo.desafiojavaaws.repository.ProductRepository;
import com.estudo.desafiojavaaws.services.aws.AwsSnsService;
import com.estudo.desafiojavaaws.services.aws.MessageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final AwsSnsService awsSnsService;

    public ProductService(CategoryService categoryService, ProductRepository productRepository, AwsSnsService awsSnsService) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.awsSnsService = awsSnsService;
    }

    public Product insert(ProductDto productDto){
        this.categoryService.getById(productDto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productDto);

        this.productRepository.save(newProduct);

        this.awsSnsService.publish(new MessageDto(newProduct.toString()));

        return newProduct;
    }

    public Product update(String id, ProductDto productDto) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (productDto.categoryId() != null){
            this.categoryService.getById(productDto.categoryId())
                    .orElseThrow(CategoryNotFoundException::new);
            product.setCategory(productDto.categoryId());
        }

        if(!productDto.title().isEmpty()){
            product.setTitle(productDto.title());
        }
        if(!productDto.description().isEmpty()){
            product.setDescription(productDto.description());
        }
        if (productDto.price() != null){
            product.setPrice(productDto.price());
        }
        this.productRepository.save(product);

        this.awsSnsService.publish(new MessageDto(product.toString()));

        return product;
    }

    public void delete(String id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(product);
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
