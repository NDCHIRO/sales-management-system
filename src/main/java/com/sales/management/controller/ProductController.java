package com.sales.management.controller;

import com.sales.management.model.Product;
import com.sales.management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/get/{id}")
    Product getAllProducts(@PathVariable Long id){
        return productService.getPorduct(id);
    }

    @PostMapping("/add/product")
    void addProduct(@RequestBody Product product){
         productService.addPorduct(product);
    }

    @PutMapping("/update/product")
    void updateProduct(@RequestBody Product product){
        productService.updatePorduct(product);
    }

    @GetMapping("/products/delete/{id}")
    void deleteProducts(@PathVariable Long id){
         productService.deleteProduct(id);
    }

}
