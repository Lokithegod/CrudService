package com.gmail.kss95kss.CrudService.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.mapper.CarMapperImpl;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.utilities.TestData;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig(classes = {CarMapperImpl.class})
public class CrudServiceApiTest extends AbstractRestControllerTest {

    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

    PageSettings pageSettings;

    @Test
    @SneakyThrows
    void ifFindAllCarThenSuccess() {
        var cars = TestData.getCarsPage();
        var response = objectMapper.writeValueAsString(cars);
        when(carSearchService.findCarsByCriteria(null,2016,30000,"",null,pageSettings)).thenReturn(cars);
        mockMvc.perform(get("/api/cars?year=2016&price=30000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

 /*   @Test
    @SneakyThrows
    void ifFindCarByYearThenSuccess() {
        var cars = TestData.getCarsList();
        var year = 2016;
        var response = objectMapper.writeValueAsString(carMapper.toListCarDto((Page<Car>) cars));
        when(carService.findCarsByYear(year)).thenReturn((Page<Car>) cars);
        mockMvc.perform(get("/api/allCars/year/{year}", year)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    void ifFindCarByCompanyNameThenSuccess() {
        var cars = TestData.getCarsList();
        var companyName = "Baza";
        var response = objectMapper.writeValueAsString(carMapper.toListCarDto((Page<Car>) cars));
        when(carService.findCarsByCompanyName("Baza")).thenReturn((Page<Car>) cars);
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
    }*/


    private String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/testRequests/" + fileName)), StandardCharsets.UTF_8);
    }

    private String getAllCarsResponse() throws IOException {
        return readFile("payment-request-missing-fields.json");
    }
}
