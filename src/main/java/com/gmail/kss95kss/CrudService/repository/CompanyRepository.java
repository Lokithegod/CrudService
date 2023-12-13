package com.gmail.kss95kss.CrudService.repository;

import com.gmail.kss95kss.CrudService.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findCompanyByName(String name);

}
