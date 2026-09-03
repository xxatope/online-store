package ru.edu.games.onlinestore.controller;

import org.springframework.web.bind.annotation.*;
import ru.edu.games.onlinestore.entity.ProductEntity;
import ru.edu.games.onlinestore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){this.productService = productService;}

    @GetMapping
    public List<ProductEntity> getAllProducts(){return productService.getAllProducts();}

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product){return productService.createProduct(product);}

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id) {return productService.getProductById(id);}

    @PutMapping("/{id}")
    public ProductEntity changeProduct(@PathVariable Long id,@RequestBody ProductEntity product){return productService.changeProduct(id, product);}

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){productService.deleteProduct(id);}

}
