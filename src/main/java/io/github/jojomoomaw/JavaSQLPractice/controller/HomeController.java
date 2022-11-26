package io.github.jojomoomaw.JavaSQLPractice.controller;

import io.github.jojomoomaw.JavaSQLPractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    public String home(){



        return "index";
    }
}
