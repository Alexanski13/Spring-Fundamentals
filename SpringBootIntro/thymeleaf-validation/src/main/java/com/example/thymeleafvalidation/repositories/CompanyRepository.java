package com.example.thymeleafvalidation.repositories;

import com.example.thymeleafvalidation.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
