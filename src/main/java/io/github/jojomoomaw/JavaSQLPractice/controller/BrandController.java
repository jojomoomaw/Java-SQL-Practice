package io.github.jojomoomaw.JavaSQLPractice.controller;

import io.github.jojomoomaw.JavaSQLPractice.model.Brand;
import io.github.jojomoomaw.JavaSQLPractice.repository.BrandRepository;
import io.github.jojomoomaw.JavaSQLPractice.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    DistributorRepository distributorRepository;

    @GetMapping("")
    public String displayBrands(Model model){

        model.addAttribute("title", "All Brands");
        model.addAttribute("brands", brandRepository.findAll());

        return "brands/list";
    }

    @RequestMapping("/add")
    public String displayAddBrandForm(Model model) {

        model.addAttribute("title", "Add Brand");
        model.addAttribute("distributors", distributorRepository.findAll());
        model.addAttribute("newBrand", new Brand());

        return "brands/add";
    }

    @PostMapping("/add")
    public String processAddBrandForm(@ModelAttribute @Valid Brand newBrand) {

        brandRepository.save(newBrand);

        return "redirect:";

    }
}
