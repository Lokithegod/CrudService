package com.gmail.kss95kss.CrudService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.kss95kss.CrudService.controller.CrudServiceController;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.utilities.TestData;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CrudServiceApiTest extends AbstractRestControllerTest {
    @Autowired
    private CrudServiceController controller;
    @Autowired
    ObjectMapper objectMapper;

    CarMapper carMapper;

    @Test
    @SneakyThrows
    void ifFindAllCarThenSuccess() {
        var cars = TestData.getCars();
        var response = objectMapper.writeValueAsString(carMapper.toListCarDto(cars));
        when(carService.findAllCar()).thenReturn(cars);
        mockMvc.perform(get("/api/allCars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    void ifFindCarByYearThenSuccess() {
        var cars = TestData.getCars();
        var year = "2016";
        var response = objectMapper.writeValueAsString(carMapper.toListCarDto(cars));
        when(carService.findCarsByYear(year)).thenReturn(cars);
        mockMvc.perform(get("/api/allCars/year/{year}", year)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    void ifFindCarByCompanyNameThenSuccess() {
        var cars = TestData.getCars();
        var companyName = "Baza";
        var response = objectMapper.writeValueAsString(carMapper.toListCarDto(cars));
        when(carService.findCarsByCompanyName("Baza")).thenReturn(cars);
        mockMvc.perform(get("/api/allCars/companyName/{companyName}", companyName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    void ifAddNewCarThenSuccess() {
        var request = readFile("save_car.json");
        mockMvc.perform(post("/api/saveCar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void ifDeleteCarThenSuccess() {
        var id = 1;
        mockMvc.perform(delete("/api/deleteCar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void ifUpdateCarThenSuccess() {
        var request = readFile("save_car.json");
        mockMvc.perform(put("/api/updateCar/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void ifSetCarToCompanyThenSuccess() {
        mockMvc.perform(put("/api/setCarToCompany/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("carId", String.valueOf(1))
                        .queryParam("companyName", "Baza"))
                .andExpect(status().isOk());
    }


    private String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/testRequests/" + fileName)), StandardCharsets.UTF_8);
    }

    private String getAllCarsResponse() throws IOException {
        return readFile("payment-request-missing-fields.json");
    }
}
