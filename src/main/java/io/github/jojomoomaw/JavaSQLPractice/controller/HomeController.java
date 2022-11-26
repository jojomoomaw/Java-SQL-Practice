package io.github.jojomoomaw.JavaSQLPractice.controller;

import io.github.jojomoomaw.JavaSQLPractice.model.Product;
import io.github.jojomoomaw.JavaSQLPractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String home(Model model){
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : productRepository.findAll()){
            if (product.isActive()){
                products.add(product);
            }
        }
        model.addAttribute("title", "Active Products:");
        model.addAttribute("products", products);

        return "index";
    }
}
