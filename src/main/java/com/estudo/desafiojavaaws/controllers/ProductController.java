package com.estudo.desafiojavaaws.controllers;

import com.estudo.desafiojavaaws.domain.product.Product;
import com.estudo.desafiojavaaws.domain.product.ProductDto;
import com.estudo.desafiojavaaws.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDto productDto){
        Product newProduct = this.productService.insert(productDto);
        return ResponseEntity.ok(newProduct);

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDto productDto){
        Product updateProduct = this.productService.update(id, productDto);
        return ResponseEntity.ok().body(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
