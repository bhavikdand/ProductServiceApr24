package com.example.Apr24FirstApi.services;

import com.example.Apr24FirstApi.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public Product getProductById(long id);

    public List<Product> getAllProducts();

    public Product createProduct(String title, String description, String image, double price, String categoryName);

    public Product updatePrice(long productId, double updatedPrice);

    public Product updateImage(long productId, String updatedImage);

    public boolean deleteProduct();
}
