package com.example.Apr24FirstApi.controllers;

import com.example.Apr24FirstApi.dtos.CreateProductRequestDto;
import com.example.Apr24FirstApi.models.Product;
import com.example.Apr24FirstApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// URL: localhost:8080
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    //Could not autowire. There is more than one bean of 'ProductService' type.
    //Beans:
    //fakeStoreProductServiceImpl   (FakeStoreProductServiceImpl.java) selfProductService   (SelfProductService.java)
    @Autowired
    public ProductController(@Qualifier("selfProduct") ProductService productService) {
        this.productService = productService;
    }

    //GET localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    public List<Product> getProducts(){
        return new ArrayList<Product>();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        // validate the data


        return productService.createProduct(requestDto.getTitle(), requestDto.getDescription(),
                requestDto.getImage(), requestDto.getPrice(), requestDto.getCategoryName());
    }
}
