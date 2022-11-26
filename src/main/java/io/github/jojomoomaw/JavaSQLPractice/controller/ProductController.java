package io.github.jojomoomaw.JavaSQLPractice.controller;

import io.github.jojomoomaw.JavaSQLPractice.model.Product;
import io.github.jojomoomaw.JavaSQLPractice.repository.BrandRepository;
import io.github.jojomoomaw.JavaSQLPractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("")
    public String displayProducts(Model model){

        model.addAttribute("title", "All Products");
        model.addAttribute("products", productRepository.findAll());

        return "products/list";
    }

    @RequestMapping("/add")
    public String displayAddProductForm(Model model) {

        model.addAttribute("title", "Add Product");
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("newProduct", new Product());

        return "products/add";
    }

    @PostMapping("/add")
    public String processProductForm(@ModelAttribute @Valid Product newProduct) {

        productRepository.save(newProduct);

        return "redirect:";

    }

}
