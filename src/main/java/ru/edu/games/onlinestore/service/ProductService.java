package ru.edu.games.onlinestore.service;

import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.controller.ProductController;
import ru.edu.games.onlinestore.entity.ProductEntity;
import ru.edu.games.onlinestore.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){this.productRepository = productRepository;}


    public List<ProductEntity> getAllProducts(){return productRepository.findAll();}

    public ProductEntity createProduct(ProductEntity product){return productRepository.save(product);}

    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт с таким id не найден: " + id));
    }

    public ProductEntity changeProduct(Long id, ProductEntity product){
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Продукт не найден c id: " + id));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id){
         productRepository.deleteById(id);
    }

}
