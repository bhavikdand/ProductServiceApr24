package com.example.Apr24FirstApi.services;

import com.example.Apr24FirstApi.configs.RedisTemplateConfig;
import com.example.Apr24FirstApi.dtos.FakeProductServiceDto;
import com.example.Apr24FirstApi.models.Category;
import com.example.Apr24FirstApi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class FakeStoreProductServiceImpl implements ProductService{


    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }



    private Product convertDtoToProduct(FakeProductServiceDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());
        product.setDescription(dto.getDescription());
        Category category = new Category();
        category.setName(dto.getCategory());
//        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(long id) {
        Product product = (Product) this.redisTemplate.opsForHash().get("PRODUCTS", "products_" + id);
        if(product != null){
            return product;
        }
        FakeProductServiceDto fakeProduct = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeProductServiceDto.class);
        Product p = convertDtoToProduct(fakeProduct);
        this.redisTemplate.opsForHash().put("PRODUCTS", "products_" + id, p);
        return p;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNumber) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String categoryName) {
        return null;
    }

    @Override
    public Product updatePrice(long productId, double updatedPrice) {
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
