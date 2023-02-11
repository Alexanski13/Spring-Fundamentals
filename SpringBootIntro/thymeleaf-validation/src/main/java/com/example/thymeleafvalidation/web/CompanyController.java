package com.example.thymeleafvalidation.web;

import com.example.thymeleafvalidation.domain.entities.Company;
import com.example.thymeleafvalidation.domain.models.CompanyAddModel;
import com.example.thymeleafvalidation.repositories.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "company-add";
    }

    @PatchMapping("/add")
    public ModelAndView patchCompany(@Valid @ModelAttribute(name = "companyAddModel") CompanyAddModel companyAddModel,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("company-add");
            return modelAndView.addObject("companyAddModel", companyAddModel);
        }
        this.companyRepository.saveAndFlush(companyAddModel.toCompany());

        modelAndView.setViewName("redirect:all");
        return modelAndView;
    }

    @GetMapping("/all")
    public String getAllCompaniesPage() {
        return "company-all";
    }

    @GetMapping("/{id}")
    public ModelAndView getCompanyPage(@PathVariable Long id, ModelAndView modelAndView) {
        Company company = this.companyRepository.findById(id).orElseThrow();
        modelAndView.setViewName("company-details");
        modelAndView.addObject("company", company);
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public String getCompanyPage(@PathVariable Long id) {
        this.companyRepository.deleteById(id);
        return "redirect:all";
    }

    @ModelAttribute(name = "companyAddModel")
    public CompanyAddModel intCompanyAddModel() {
        return new CompanyAddModel();
    }

    @ModelAttribute(name = "allCompanies")
    public List<Company> listOfAllCompanies() {
        return this.companyRepository.findAll();
    }

}
