package com.mdemiguels.springbootweb.controller;

import com.mdemiguels.springbootweb.model.Product;
import com.mdemiguels.springbootweb.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        return "products";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        return "products";
    }
}
