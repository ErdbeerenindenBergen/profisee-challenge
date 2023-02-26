package com.kassiburnett.challengeprofisee.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.kassiburnett.challengeprofisee.dao.ProductDao;
import com.kassiburnett.challengeprofisee.model.Product;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productDao.findAllProducts();
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productDao.updateProduct(product);
    }

}

