package com.kassiburnett.challengeprofisee.dao;

import com.kassiburnett.challengeprofisee.model.Product;
import com.kassiburnett.challengeprofisee.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAllProducts() {
        String sql = "SELECT * FROM product ORDER BY product_id ASC ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Product> products = new ArrayList<>();
        while (results.next()) {
            Product product = mapToRow(results);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        String sql = "UPDATE product SET product_name = ?, manufacturer = ?, product_style = ?, " + " purchase_price = ?, sale_price = ?, qty_on_hand = ?, commission_percent = ?, upc_code = ? " + " WHERE product_id=?;";
        jdbcTemplate.update(sql, product.getName(), product.getManufacturer(), product.getStyle(), product.getPurchasePrice(), product.getSalePrice(), product.getQtyOnHand(), product.getCommissionPercent(), product.getUpcCode(), product.getProductId());
        return product;
    }

    @Override
    public Product findProductById(int productId) {
        String sql = "SELECT * FROM product WHERE product_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
        Product product = mapToRow(results);
        return product;
    }

    @Override
    public void updateStockOfProduct(Sale sale) {
        String sql = " UPDATE product SET qty_on_hand = qty_on_hand - 1 WHERE product_id = ?;";
        jdbcTemplate.update(sql, sale.getProductId());
    }

    @Override
    public boolean createProduct(Product product) {
        String sql = "INSERT INTO product (product_name, manufacturer, product_style, purchase_price, sale_price, qty_on_hand, commission_percent, upc_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getManufacturer(), product.getStyle(), product.getPurchasePrice(), product.getSalePrice(), product.getQtyOnHand(), product.getCommissionPercent(), product.getUpcCode()) == 1;
    }

    public Product mapToRow(SqlRowSet rs) {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setName(rs.getString("product_name"));
        product.setManufacturer(rs.getString("manufacturer"));
        product.setStyle(rs.getString("product_style"));
        product.setPurchasePrice(rs.getBigDecimal("purchase_price"));
        product.setSalePrice(rs.getBigDecimal("sale_price"));
        product.setQtyOnHand(rs.getInt("qty_on_hand"));
        product.setCommissionPercent(rs.getBigDecimal("commission_percent"));
        product.setUpcCode(rs.getLong("upc_code"));
        return product;
    }
}
