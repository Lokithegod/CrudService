package com.gmail.kss95kss.CrudService.controller;

import com.gmail.kss95kss.CrudService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CrudServiceController {

    @Autowired
    CarRepository crudServiceRepository;
}
