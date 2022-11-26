package io.github.jojomoomaw.JavaSQLPractice.controller;

import io.github.jojomoomaw.JavaSQLPractice.model.Distributor;
import io.github.jojomoomaw.JavaSQLPractice.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/distributors")
public class DistributorController {
    @Autowired
    DistributorRepository distributorRepository;

    @GetMapping("")
    public String displayDistributor(Model model){

        model.addAttribute("title", "All Distributors");
        model.addAttribute("distributors", distributorRepository.findAll());

        return "distributors/list";
    }

    @RequestMapping("/add")
    public String displayAddDistributorForm(Model model) {
        model.addAttribute("title", "Add Distributor");
        model.addAttribute("newDistributor", new Distributor());

        return "distributors/add";
    }

    @PostMapping("/add")
    public String processDistributorForm(@ModelAttribute @Valid Distributor newDistributor) {

        for(Distributor distributor : distributorRepository.findAll()){
            if(distributor.getName().equals(newDistributor.getName())){
                //this is my dumb error handling that just ignores you if you re-entera distributor name
                return "redirect:";
            } else if (newDistributor.getName().isEmpty()) {
                return "distributors/add";
            }

            distributorRepository.save(newDistributor);

        }
        return "redirect:";
    }
}
