package com.example.Apr24FirstApi.controllers;

import com.example.Apr24FirstApi.components.AuthUtils;
import com.example.Apr24FirstApi.dtos.CreateProductRequestDto;
import com.example.Apr24FirstApi.models.Product;
import com.example.Apr24FirstApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// URL: localhost:8080
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private AuthUtils authUtils;


    //Could not autowire. There is more than one bean of 'ProductService' type.
    //Beans:
    //fakeStoreProductServiceImpl   (FakeStoreProductServiceImpl.java) selfProductService   (SelfProductService.java)
    @Autowired
    public ProductController(@Qualifier("selfProduct") ProductService productService, AuthUtils authUtils) {
        this.productService = productService;
        this.authUtils = authUtils;
    }

    //GET localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){
        return productService.getProductById(id);
    }

    public List<Product> getProducts(){
        return new ArrayList<Product>();
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto, @RequestHeader("Auth") String token){
        // validate the data
        if(!authUtils.validateToken(token)){
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }


        Product product = productService.createProduct(requestDto.getTitle(), requestDto.getDescription(),
                requestDto.getImage(), requestDto.getPrice(), requestDto.getCategoryName());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum){

        Page<Product> products = productService.getAllProducts(pageSize, pageNum);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
