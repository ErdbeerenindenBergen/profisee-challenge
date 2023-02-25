package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Product;

import java.util.List;

public interface ProductDao {

    //displays a list of products
    List<Product> findAllProducts();

    //update a product
    Product updateProduct();
}
