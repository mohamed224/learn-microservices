package com.mtrade.products.web.controller;

import com.mtrade.products.configurations.AppPropertiesConfiguration;
import com.mtrade.products.dao.ProductDao;
import com.mtrade.products.model.Product;
import com.mtrade.products.web.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductDao productDao;
    private AppPropertiesConfiguration propertiesConfiguration;

    @Autowired
    public ProductController(ProductDao productDao, AppPropertiesConfiguration propertiesConfiguration) {
        this.productDao = productDao;
        this.propertiesConfiguration = propertiesConfiguration;
    }

    @GetMapping("/products")
    public List<Product> productsList(){
        List<Product> productLimitedList = productDao.findAll().subList(0,propertiesConfiguration.getLimitDeProduits());

        return productLimitedList;
    }

    @GetMapping("/products/{id}")
    public Optional<Product> findProductById(@PathVariable int id) {
        Optional<Product> product = productDao.findById(id);
        if(!product.isPresent()) throw new ProductNotFoundException("Product with id : "+id+" do not exist.");
        return product;
    }
}
