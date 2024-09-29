package com.sales.management.service;

import com.sales.management.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getPorduct(Long id);
    void addPorduct(Product product);
    void updatePorduct(Product updatedProduct);
    void deleteProduct(Long id);

}
