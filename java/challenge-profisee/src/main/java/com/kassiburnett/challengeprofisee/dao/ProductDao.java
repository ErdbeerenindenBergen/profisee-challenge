package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Product;
import com.kassiburnett.challengeprofisee.model.Sale;

import java.util.List;

public interface ProductDao {

    List<Product> findAllProducts();

    Product updateProduct(Product product);

    Product findProductById(int productId);

    void updateStockOfProduct(Sale sale);

    boolean createProduct(Product product);
}
