package com.mdemiguels.springbootweb.services;

import com.mdemiguels.springbootweb.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();


    public List<Product> findAll() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
 }
