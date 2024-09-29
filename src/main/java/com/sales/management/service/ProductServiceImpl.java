package com.sales.management.service;

import com.sales.management.model.Product;
import com.sales.management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getPorduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void addPorduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updatePorduct(Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(updatedProduct.getId());

        if(existingProduct.isPresent()) {
            Product newProduct = existingProduct.get();
            newProduct.setName(updatedProduct.getName());
            newProduct.setDescription(updatedProduct.getDescription());
            newProduct.setCategory(updatedProduct.getCategory());
            newProduct.setPrice(updatedProduct.getPrice());
            newProduct.setQuantity(updatedProduct.getQuantity());

            productRepository.save(newProduct);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
