package com.example.thymeleafvalidation.domain.models;

import com.example.thymeleafvalidation.domain.entities.Company;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CompanyAddModel {


    @DecimalMin(value = "1")
    @DecimalMax(value = "1000000000")
    @NotNull
    private BigDecimal budget;

    @Size(min = 10)
    private String description;

    @Size(min = 2, max = 10)
    private String name;

    @Size(min = 2, max = 10)
    private String town;

    public Company toCompany() {
        return Company.builder().budget(budget).description(description).name(name).town(town).build();
    }
}
