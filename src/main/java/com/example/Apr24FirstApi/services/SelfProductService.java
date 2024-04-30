package com.example.Apr24FirstApi.services;

import com.example.Apr24FirstApi.models.Category;
import com.example.Apr24FirstApi.models.Product;
import com.example.Apr24FirstApi.repositories.CategoryRepository;
import com.example.Apr24FirstApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProduct")
public class SelfProductService implements ProductService{


    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String categoryName) {
        Category category = categoryService.createCategory(categoryName);
        Product product = new Product();
        product.setCategory(category);
        product.setTitle(title);
        product.setPrice(price);
        product.setImage(image);
        product.setDescription(description);
        return productRepository.save(product);
    }

    @Override
    public Product updatePrice(long productId, double updatedPrice) {
        //fetch the existing product
        //product.setPrice(updatedPrice)
        //return productRepository.save(product)
        return null;
    }

    @Override
    public Product updateImage(long productId, String updatedImage) {
        return null;
    }

    @Override
    public boolean deleteProduct() {
        return false;
    }
}
