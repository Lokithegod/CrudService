package com.gmail.kss95kss.CrudService.api;

import com.gmail.kss95kss.CrudService.controller.CrudServiceController;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.repository.CarRepositoryCrud;
import com.gmail.kss95kss.CrudService.repository.CarSearchRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.service.CarSearchService;
import com.gmail.kss95kss.CrudService.service.CarService;
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
    protected CarSearchService carSearchService;
    @MockBean
    protected CompanyRepository companyRepository;
    @MockBean
    protected CarRepositoryCrud carRepository;
    @MockBean
    protected CarSearchRepository carSearchRepository;
    @Autowired
    CarMapper carMapper;

}
