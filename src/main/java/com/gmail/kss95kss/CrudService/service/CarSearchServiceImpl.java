package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.controller.domain.validation.CarName;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.repository.CarRepositoryCrud;
import com.gmail.kss95kss.CrudService.repository.CarSearchRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.repository.specification.CarSearchParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarSearchServiceImpl implements CarSearchService {
    private final CarRepositoryCrud carRepository;

    private final CarSearchRepository carSearchRepository;

    private final CompanyRepository companyRepository;

    private final CarMapper carMapper;

    private static final int carInCompany = 10;

    private final PageSettings pageSettings = new PageSettings();

    @Override
    public Page<Car> findCarsByCriteria(CarName name, int year, int price, String model, String companyName, PageSettings pageSettings) {
        var searchParams = new CarSearchParams(name, year, price, model, companyName);
        LOG.info("Params is : {}", searchParams);
        var cars = carSearchRepository.findCarsByCriteria(searchParams, PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage()));
        return cars;
    }
}
