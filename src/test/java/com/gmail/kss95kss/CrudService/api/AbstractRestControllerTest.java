package com.gmail.kss95kss.CrudService.api;

import com.gmail.kss95kss.CrudService.controller.CrudServiceController;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.repository.CarRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.service.CarService;
import com.gmail.kss95kss.CrudService.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
        CrudServiceController.class
})
public class AbstractRestControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    protected CarService carService;
    @MockBean
    protected CompanyRepository companyRepository;
    @MockBean
    protected CarRepository carRepository;
    @Autowired
    CarMapper carMapper;

}
